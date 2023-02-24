package com.capg.ipl.exception;

public class TeamNotFoundException extends Exception{
	private String message;
	public TeamNotFoundException() {
		super();
	}
	public TeamNotFoundException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String toString() {
		return "TeamNotFoundException [message=" + message + "]";
	}
}
