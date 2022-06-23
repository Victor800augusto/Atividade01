package com.acelera.biblioteca.dto.inputs;

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
}
