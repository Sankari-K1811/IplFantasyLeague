package com.capg.ipl.exception;

public class MatchAlreadyExistsException extends Exception{
	private String message;
	public MatchAlreadyExistsException() {
		super();
	}
	public MatchAlreadyExistsException(String message) {
		super();
		this.message = message;
	}
    public String getMessage() {
    	return this.message;
    }

}
