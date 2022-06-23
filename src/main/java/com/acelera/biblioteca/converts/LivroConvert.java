package com.acelera.biblioteca.converts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acelera.biblioteca.dto.inputs.LivroInput;
import com.acelera.biblioteca.dto.outputs.LivroOutput;
import com.acelera.biblioteca.dto.outputs.LivroSemAutorOutput;
import com.acelera.biblioteca.entities.AutorEntity;
import com.acelera.biblioteca.entities.LivroEntity;
import com.acelera.biblioteca.services.AutorService;


@Component
public class LivroConvert {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AutorService autorService;
	
	public LivroEntity inputToEntity(LivroInput livroInput) {
		LivroEntity livroEntity = modelMapper.map(livroInput, LivroEntity.class);
		converteIdsAutorParaAutores(livroInput, livroEntity);
		return livroEntity;
	}
	
	public LivroOutput entityToOutput(LivroEntity livroEntity) {
		return modelMapper.map(livroEntity, LivroOutput.class);
	}
	
	public List<LivroOutput> entityToOutput(List<LivroEntity> livros) {
		return livros.stream().map(livroEntity -> {
			return entityToOutput(livroEntity);
		}).collect(Collectors.toList());
	}
	
	public LivroSemAutorOutput entityToSemAutorOutput(LivroEntity livroEntity) {
		return modelMapper.map(livroEntity, LivroSemAutorOutput.class);
	}
	
	public List<LivroSemAutorOutput> entityToSemAutorOutput(List<LivroEntity> livros) {
		return livros.stream().map(livroEntity -> {
			return entityToSemAutorOutput(livroEntity);
		}).collect(Collectors.toList());
	}
	
	public void copyInputToEntity(LivroEntity livroEntity, LivroInput livroInput) {
		modelMapper.map(livroInput, livroEntity);
		converteIdsAutorParaAutores(livroInput, livroEntity);
	}
	
	private void converteIdsAutorParaAutores(LivroInput livroInput, LivroEntity livroEntity) {
		List<AutorEntity> autores = new ArrayList<>();
		for (Long idAutor : livroInput.getIdsAutores()) {
			AutorEntity autor = autorService.buscaPeloId(idAutor);
			autores.add(autor);
		}
		livroEntity.setAutores(autores);
	}
	
}
