package com.qsp.hospital_Management.exception;

public class PincodeNotFound extends RuntimeException{
	private String message;
	public PincodeNotFound() {
		
	}
	public PincodeNotFound(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}

}
