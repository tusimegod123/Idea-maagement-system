package com.flhub.ideams.Exceptions;



public class RecordNotFoundException extends Exception {
private static final long serialVersionUID = 1L;
	
	public RecordNotFoundException(String message) {
		super(message);
	}
	
	public RecordNotFoundException(String message, Throwable t) {
		super(message, t);
	}

}
