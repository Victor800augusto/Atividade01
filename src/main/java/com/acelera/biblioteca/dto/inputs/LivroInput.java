package com.acelera.biblioteca.dto.inputs;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroInput {

	@NotNull(message = "O título é obrigatório!")
	@Size(min = 2, max = 200, message = "O título deve conter entre 2 e 200 caracteres!")
	private String titulo;

	@NotNull(message = "O ano de lançamento é obrigatório!")
	private Integer anoLancamento;

	@NotEmpty(message = "O livro deve ter pelo menos 1 autor!")
	private List<Long> idsAutores;
}
