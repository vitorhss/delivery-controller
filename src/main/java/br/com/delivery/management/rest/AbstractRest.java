package br.com.delivery.management.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class AbstractRest {
	protected <T> ResponseEntity<T> responseOk(T body) {
		return new ResponseEntity<T>(body, HttpStatus.OK);
	}
}
