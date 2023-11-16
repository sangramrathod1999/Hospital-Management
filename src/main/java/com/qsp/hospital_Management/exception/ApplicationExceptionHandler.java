package com.qsp.hospital_Management.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.hospital_Management.util.ResponseStructure;
@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> idNotFound(IdNotFound exception){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		
		structure.setMessage("Id Not Found Exception");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData(exception.getMessage());
		return  new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(DataNotFound.class)
	public ResponseEntity<ResponseStructure<String>> dataNotFound(DataNotFound exception){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		
		structure.setMessage("Id Not Found Exception");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData(exception.getMessage());
		return  new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmailNotFound.class)
	public ResponseEntity<ResponseStructure<String>> emailNotFound(EmailNotFound exception){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		
		structure.setMessage("Id Not Found Exception");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData(exception.getMessage());
		return  new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PhoneNumberNotFound.class)
	public ResponseEntity<ResponseStructure<String>> phoneNumberNotFound(PhoneNumberNotFound exception){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		
		structure.setMessage("Id Not Found Exception");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData(exception.getMessage());
		return  new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PincodeNotFound.class)
	public ResponseEntity<ResponseStructure<String>> pincodeNotFound(PincodeNotFound exception){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		
		structure.setMessage("Id Not Found Exception");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData(exception.getMessage());
		return  new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError>list=ex.getAllErrors();
		Map<String,String>map=new HashMap<String, String>();
		
		for(ObjectError oe:list) {
			FieldError error=(FieldError)oe;
			String name=error.getField();
			String message=error.getDefaultMessage();
			map.put(name, message);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
		
		
	}

}
