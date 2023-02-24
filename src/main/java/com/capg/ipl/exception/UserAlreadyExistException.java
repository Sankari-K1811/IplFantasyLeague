package com.capg.ipl.exception;

public class UserAlreadyExistException extends Exception{
	private String message;
	public UserAlreadyExistException() {
		super();
	}
	public UserAlreadyExistException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
