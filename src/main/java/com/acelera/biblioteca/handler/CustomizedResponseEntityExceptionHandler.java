package com.acelera.biblioteca.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.acelera.biblioteca.exceptions.AutorNotFoundException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(AutorNotFoundException.class)
	public final ResponseEntity<ProblemExceptionOutput> handlerNotFoundBussinessException(AutorNotFoundException exception,
			WebRequest request) {
		ProblemExceptionOutput problema = new ProblemExceptionOutput(HttpStatus.NOT_FOUND.value(),
				exception.getMessage());
		return new ResponseEntity<ProblemExceptionOutput>(problema, HttpStatus.NOT_FOUND);
	}

}
