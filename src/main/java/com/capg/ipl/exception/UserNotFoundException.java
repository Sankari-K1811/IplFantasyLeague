package com.capg.ipl.exception;

public class UserNotFoundException extends Exception{
	private String message;
	public UserNotFoundException() {
		super();
	}
	public UserNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
