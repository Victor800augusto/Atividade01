package com.acelera.biblioteca.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acelera.biblioteca.converts.AutorConvert;
import com.acelera.biblioteca.dto.inputs.AutorInput;
import com.acelera.biblioteca.dto.outputs.AutorOutput;
import com.acelera.biblioteca.entities.Autor;
import com.acelera.biblioteca.services.AutorService;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

	@Autowired
	private AutorService autorService;
	
	@Autowired
	private AutorConvert autorConvert;
	
	@PostMapping
	public AutorOutput cria(@RequestBody @Valid AutorInput autorInput) {
		Autor autor = autorConvert.inputToEntity(autorInput);
		Autor novoAutor = autorService.criaAutor(autor);
		return autorConvert.entityToOutput(novoAutor);
	}
}
