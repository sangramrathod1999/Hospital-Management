package com.qsp.hospital_Management.exception;

public class DataNotFound extends RuntimeException {
	private String message;

	public DataNotFound() {
		// TODO Auto-generated constructor stub
	}

	public DataNotFound(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

}
