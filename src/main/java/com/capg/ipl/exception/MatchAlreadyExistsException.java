package com.capg.ipl.exception;

public class MatchAlreadyExistsException extends Exception{
	private  String message;
	public MatchAlreadyExistsException() {
		super();
		
	}
	public MatchAlreadyExistsException(String message) {
		super();
		this.message = message;
	}
	@Override
    public String getMessage() {
    	return this.message;
    }

}
