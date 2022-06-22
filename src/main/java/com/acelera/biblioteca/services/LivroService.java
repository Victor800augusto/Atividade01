package com.acelera.biblioteca.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acelera.biblioteca.entities.LivroEntity;
import com.acelera.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	public LivroEntity cadastraLivro(LivroEntity livroEntity) {
		return livroRepository.save(livroEntity);
	}
}