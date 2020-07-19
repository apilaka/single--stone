package com.sai.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ContactRestExceptionHandler {

	// Add an exception handler for CustomerNotFoundException
	@ExceptionHandler
	public ResponseEntity<ContactErrorResponse> handleException(ContactNotFoundException exc) {	
		ContactErrorResponse error = new ContactErrorResponse(
			
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());			
	return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}	
// Add another exception handler ... to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<ContactErrorResponse> handleException(Exception exc) {	
		// create CustomerErrorResponse
		ContactErrorResponse error = new ContactErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());	
		// return ResponseEntity		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}





