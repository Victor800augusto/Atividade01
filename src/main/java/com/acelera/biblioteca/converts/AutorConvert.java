package com.acelera.biblioteca.converts;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.acelera.biblioteca.dto.inputs.AutorInput;
import com.acelera.biblioteca.dto.outputs.AutorOutput;
import com.acelera.biblioteca.entities.AutorEntity;


@Component
public class AutorConvert {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public AutorEntity inputToEntity(AutorInput autorInput) {
		return modelMapper.map(autorInput, AutorEntity.class);
	}
	
	public AutorOutput entityToOutput(AutorEntity autorEntity) {
		return modelMapper.map(autorEntity, AutorOutput.class);
	}

	public void copyInputToEntity(AutorEntity autorEntity, AutorInput autorInput) {
		modelMapper.map(autorInput, autorEntity);
	}
}
