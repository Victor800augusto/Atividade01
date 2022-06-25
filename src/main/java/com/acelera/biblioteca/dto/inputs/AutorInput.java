package com.acelera.biblioteca.dto.inputs;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorInput {

	@NotNull(message="O nome é obrigatório!")
	@Size(min = 2, max = 100, message = "O Nome deve conter entre 2 e 100 caracteres!")
	private String nome;
	
	@NotNull(message="A bibliografia é obrigatória!")
	@Size(min = 1, max = 1000, message = "A bibliografia deve conter entre 1 e 1000 caracteres!")
	private String bibliografia;
	
	@AssertTrue(message = "O Nome está inválido! Ele deve ser composto por pelo menos 2 palavras.")
	public boolean isNomeCompleto() {

		if (nome == null) {
			return false;
		}

		nome = nome.trim();

		if (!nome.contains(" ")) {
			return false;
		}

		return true;
	}
}
