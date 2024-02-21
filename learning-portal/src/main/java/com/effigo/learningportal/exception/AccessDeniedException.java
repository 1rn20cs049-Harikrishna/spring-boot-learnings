package com.effigo.learningportal.exception;


/*
 * When user try to access the resources other than his resource then this exception is
 * raised by telling your are invalid user for this resources
 * 
 */

public class AccessDeniedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AccessDeniedException(String message) {
		super(message);
 }

}
