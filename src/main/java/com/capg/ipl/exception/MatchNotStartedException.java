package com.capg.ipl.exception;

public class MatchNotStartedException extends Exception{
	private String message;
	public  MatchNotStartedException () {
		super();
	}
	public  MatchNotStartedException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return this.message;
	}

}
