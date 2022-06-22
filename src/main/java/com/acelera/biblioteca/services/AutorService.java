package com.acelera.biblioteca.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acelera.biblioteca.entities.Autor;
import com.acelera.biblioteca.repositories.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;
	
	public Autor criaAutor(Autor autorEntity) {
		return autorRepository.save(autorEntity);
	}
}
