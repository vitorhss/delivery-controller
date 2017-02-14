package br.com.delivery.management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.delivery.management.exception.BusinessException;

@ControllerAdvice
public class ExceptionHandlingController {
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<Error> BusinessException(BusinessException exception){
		return new ResponseEntity<Error>(new Error(exception.getMessage()), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> Exception (Exception exception){
		return new ResponseEntity<Error>(new Error(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
