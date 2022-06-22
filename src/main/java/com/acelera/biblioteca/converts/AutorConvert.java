package com.acelera.biblioteca.converts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acelera.biblioteca.dto.inputs.AutorInput;
import com.acelera.biblioteca.dto.outputs.AutorOutput;
import com.acelera.biblioteca.entities.Autor;


@Component
public class AutorConvert {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Autor inputToEntity(AutorInput autorInput) {
		return modelMapper.map(autorInput, Autor.class);
	}
	
	public AutorOutput entityToOutput(Autor autor) {
		return modelMapper.map(autor, AutorOutput.class);
	}

}
