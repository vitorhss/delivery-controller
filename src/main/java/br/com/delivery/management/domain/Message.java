package br.com.delivery.management.domain;

public class Message {
	private String message;
	private String messageDetail;

	public Message(String message) {
		super();
		this.message = message;
	}

	public Message(String message, String messageDetail) {
		super();
		this.message = message;
		this.messageDetail = messageDetail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageDetail() {
		return messageDetail;
	}

	public void setMessageDetail(String messageDetail) {
		this.messageDetail = messageDetail;
	}

}
