package com.acelera.biblioteca.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acelera.biblioteca.entities.AutorEntity;
import com.acelera.biblioteca.repositories.AutorRepository;


@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;
	
	public AutorEntity criaAutor(AutorEntity autorEntity) {
		return autorRepository.save(autorEntity);
	}
	
	public AutorEntity alteraAutor(AutorEntity autorEntity) {
		return autorRepository.save(autorEntity);
	}
	
	public AutorEntity buscaPeloId(Long id) {
		return autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor não encontrado!"));
	}
}
