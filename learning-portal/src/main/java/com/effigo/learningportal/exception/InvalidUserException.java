package com.effigo.learningportal.exception;

/*
 * if user provides the wrong credentials 
 */
public class InvalidUserException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidUserException(String message) {
		super(message);

	}

}
