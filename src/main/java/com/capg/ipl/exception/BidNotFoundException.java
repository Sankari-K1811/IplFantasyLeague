package com.capg.ipl.exception;

public class BidNotFoundException extends Exception {
	private String message;
	public BidNotFoundException() {
		super();
	}
	public BidNotFoundException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return this.message;
	}

}
