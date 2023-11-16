package com.qsp.hospital_Management.exception;

public class PhoneNumberNotFound extends RuntimeException {
	
	private String message;
	
	public PhoneNumberNotFound() {
	}

	public PhoneNumberNotFound(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
