package com.acelera.biblioteca.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.acelera.biblioteca.exceptions.NotFoundBussinessException;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotFoundBussinessException.class)
	public final ResponseEntity<ProblemExceptionOutput> handlerNotFoundBussinessException(NotFoundBussinessException exception,
			WebRequest request) {
		ProblemExceptionOutput problema = new ProblemExceptionOutput(HttpStatus.NOT_FOUND.value(),
				exception.getMessage());
		return new ResponseEntity<ProblemExceptionOutput>(problema, HttpStatus.NOT_FOUND);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String detail = "Um ou mais campos estão inválidos.";

		BindingResult bindingResult = ex.getBindingResult();
		
		List<FieldsExceptionOutput> problemObjects = bindingResult.getAllErrors().stream().map(objectError -> {
			String message = objectError.getDefaultMessage();
			String name = objectError.getObjectName();

			if (objectError instanceof FieldError) {
				name = ((FieldError) objectError).getField();
			}

			message = message.replace("{1}", name);
			
			return FieldsExceptionOutput.builder().name(name).message(message).build();
		}).collect(Collectors.toList());

		ProblemExceptionOutput problema = new ProblemExceptionOutput(HttpStatus.BAD_REQUEST.value(), detail,
				problemObjects);

		return new ResponseEntity<Object>(problema, HttpStatus.BAD_REQUEST);
	}

}
