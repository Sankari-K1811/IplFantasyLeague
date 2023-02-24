package com.capg.ipl.exception;

public class MatchNotFoundException extends Exception{
	private String message;
	public MatchNotFoundException() {
		super();
	}
	public MatchNotFoundException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String toString() {
		return "MatchNotFoundException [message=" + message + "]";
	}

}
