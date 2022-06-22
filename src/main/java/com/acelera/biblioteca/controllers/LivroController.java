package com.acelera.biblioteca.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acelera.biblioteca.converts.LivroConvert;
import com.acelera.biblioteca.dto.inputs.LivroInput;
import com.acelera.biblioteca.dto.outputs.LivroOutput;
import com.acelera.biblioteca.entities.LivroEntity;
import com.acelera.biblioteca.services.LivroService;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

	@Autowired
	private LivroService livroService;
	
	@Autowired
	private LivroConvert livroConvert;
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	public LivroOutput cadastraLivro(@RequestBody @Valid LivroInput livroInput) {
		LivroEntity livroEntity = livroConvert.inputToEntity(livroInput);
		LivroEntity novoLivro = livroService.cadastraLivro(livroEntity);
		return livroConvert.entityToOutput(novoLivro);
	}
	
	@PutMapping("/{id}")
	public LivroOutput alteraLivro(@PathVariable Long id,@RequestBody @Valid LivroInput livroInput) {
		LivroEntity livroCadastrado = livroService.buscaPeloId(id);
		livroConvert.copyInputToEntity(livroCadastrado, livroInput);
		LivroEntity livroAtualizado = livroService.alteraLivro(livroCadastrado);
		return livroConvert.entityToOutput(livroAtualizado);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deletaLivro(@PathVariable Long id) {
		LivroEntity livroCadastrado = livroService.buscaPeloId(id);
		livroService.deletaLivro(livroCadastrado);
	}
	
	@GetMapping
	public List<LivroOutput> listaTodos(){
		List<LivroEntity> livros = livroService.listaTodos();
		return livroConvert.entityToOutput(livros);
	}
	
	@GetMapping("/{id}")
	public LivroOutput buscaLivroPeloId(@PathVariable Long id) {
		LivroEntity livroCadastrado = livroService.buscaPeloId(id);
		return livroConvert.entityToOutput(livroCadastrado);
	}
}
