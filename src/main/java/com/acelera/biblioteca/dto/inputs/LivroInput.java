package com.acelera.biblioteca.dto.inputs;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroInput {

	@NotNull(message = "O título é obrigatório!")
	private String titulo;

	@NotNull(message = "O ano de lançamento é obrigatório!")
	private Integer anoLancamento;

	@NotEmpty(message = "O livro deve ter pelo menos 1 autor!")
	private List<Long> idsAutores;
}
