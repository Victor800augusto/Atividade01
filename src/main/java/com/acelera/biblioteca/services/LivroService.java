package com.acelera.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acelera.biblioteca.entities.LivroEntity;
import com.acelera.biblioteca.exceptions.NotFoundBussinessException;
import com.acelera.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	public LivroEntity cadastraLivro(LivroEntity livroEntity) {
		return livroRepository.save(livroEntity);
	}
	
	public LivroEntity alteraLivro(LivroEntity livroEntity) {
		return livroRepository.save(livroEntity);
	}
	
	public LivroEntity buscaPeloId(Long id) {
		return livroRepository.findById(id).orElseThrow(() -> new NotFoundBussinessException("Não foi encontrado livro de id " + id));
	}
	
	public List<LivroEntity> listaLivrosPeloIdAutor(Long id){
		return livroRepository.findAllByAutoresId(id);
	}
	
	public void deletaLivro(LivroEntity livroCadastrado) {
		livroRepository.delete(livroCadastrado);
	}
	
	public List<LivroEntity> listaTodos(){
		return livroRepository.findAll();
	}
}
