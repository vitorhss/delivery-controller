package br.com.delivery.management.domain;

public class FieldErro implements Comparable<FieldErro> {

	private String field;
	private String error;

	public FieldErro(String field, String error) {
		super();
		this.field = field;
		this.error = error;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public int compareTo(FieldErro o) {
		return this.field.compareTo(o.getField());
	}

}
