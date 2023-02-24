package com.capg.ipl.exception;

public class MatchAlreadyInProgressException extends Exception {
	private String message;
	public MatchAlreadyInProgressException() {
		super();
	}
	public MatchAlreadyInProgressException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String toString() {
		return "MatchAlreadyInProgressException [message=" + message + "]";
	}
}
