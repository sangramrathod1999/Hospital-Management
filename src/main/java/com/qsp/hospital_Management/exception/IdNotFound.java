package com.qsp.hospital_Management.exception;

public class IdNotFound extends RuntimeException{
	
	private String message;
	
	public IdNotFound() {
	}
	
	public IdNotFound(String message) {
		super();
		this.message=message;
	}
	
	
	public String getMessage() {
		return message;
	}
	
	
	
	

}
