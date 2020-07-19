package com.sai.springdemo.rest;

public class ContactNotFoundException extends RuntimeException {

	public ContactNotFoundException() {
	}

	public ContactNotFoundException(String message) {
		super(message);
	}

	public ContactNotFoundException(Throwable cause) {
		super(cause);
	}

	public ContactNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ContactNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
