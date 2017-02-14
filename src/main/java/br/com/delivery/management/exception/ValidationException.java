package br.com.delivery.management.exception;

import org.springframework.validation.Errors;

public class ValidationException extends BusinessException {
	
	private static final long serialVersionUID = 1L;
	private final Errors errors;

	public ValidationException(Errors errors) {
		super();
		this.errors = errors;
	}

	public Errors getErrors() {
		return errors;
	}

}
