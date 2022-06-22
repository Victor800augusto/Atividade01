package com.acelera.biblioteca.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acelera.biblioteca.converts.AutorConvert;
import com.acelera.biblioteca.dto.inputs.AutorInput;
import com.acelera.biblioteca.dto.outputs.AutorOutput;
import com.acelera.biblioteca.entities.AutorEntity;
import com.acelera.biblioteca.services.AutorService;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

	@Autowired
	private AutorService autorService;
	
	@Autowired
	private AutorConvert autorConvert;
	
	@PostMapping
	public AutorOutput cadastraAutor(@RequestBody @Valid AutorInput autorInput) {
		AutorEntity autorEntity = autorConvert.inputToEntity(autorInput);
		AutorEntity novoAutor = autorService.criaAutor(autorEntity);
		return autorConvert.entityToOutput(novoAutor);
	}
	
	@PutMapping("/{id}")
	public AutorOutput alteraAutor(@PathVariable Long id,@RequestBody @Valid AutorInput autorInput) {
		AutorEntity autorCadastrado = autorService.buscaPeloId(id);
		autorConvert.copyInputToEntity(autorCadastrado, autorInput);
		AutorEntity autorAtualizado = autorService.alteraAutor(autorCadastrado);
		return autorConvert.entityToOutput(autorAtualizado);
	}
	
	@GetMapping
	public List<AutorOutput> listaTodos(){
		List<AutorEntity> autores = autorService.listaTodos();
		return autorConvert.entityToOutput(autores);
	}
}
