package com.capg.ipl.exception;

public class BidAlreadyExistException extends Exception{
	private String message;
	public BidAlreadyExistException() {
		super();
	}
	public BidAlreadyExistException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return this.message;
	}
}
