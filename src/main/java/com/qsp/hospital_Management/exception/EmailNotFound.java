package com.qsp.hospital_Management.exception;

public class EmailNotFound extends RuntimeException{
	private String message;
	
	public EmailNotFound() {

	}

	public EmailNotFound(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
	
	

}
