package com.capg.ipl.exception;

public class BidderNotFoundException extends Exception{
	private String message;
	public BidderNotFoundException() {
		super();
	}
	public BidderNotFoundException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String toString() {
		return "BidderNotFoundException [message=" + message + "]";
	}
	
}
