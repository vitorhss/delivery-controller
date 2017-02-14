package br.com.delivery.management.domain;

public class Error {
	private String message;
	private String detalheErro;

	public Error(String message, String detalheErro) {
		super();
		this.message = message;
		this.detalheErro = detalheErro;
	}

	public Error(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetalheErro() {
		return detalheErro;
	}

	public void setDetalheErro(String detalheErro) {
		this.detalheErro = detalheErro;
	}

}
