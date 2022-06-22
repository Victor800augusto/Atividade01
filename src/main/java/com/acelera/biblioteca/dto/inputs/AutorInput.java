package com.acelera.biblioteca.dto.inputs;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorInput {

	@NotNull(message="O nome é obrigatório!")
	private String nome;
	
	@NotNull(message="A bibliografia é obrigatória!")
	private String bibliografia;
}
