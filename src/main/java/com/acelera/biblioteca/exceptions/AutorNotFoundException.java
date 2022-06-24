package com.acelera.biblioteca.exceptions;

public class AutorNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public AutorNotFoundException(Long id) {
		super("Não foi encontrada o autor de id: " + id);
	}
}
