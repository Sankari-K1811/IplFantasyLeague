package com.capg.ipl.exception;

public class TeamAlreadyExistException extends Exception{
	private String message;
	public TeamAlreadyExistException() {
		super();
	}
	public TeamAlreadyExistException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String toString() {
		return "TeamAlreadyExistException [message=" + message + "]";
	}

}
