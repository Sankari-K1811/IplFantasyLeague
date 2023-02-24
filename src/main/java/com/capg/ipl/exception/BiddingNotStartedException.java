package com.capg.ipl.exception;

public class BiddingNotStartedException extends Exception{
	private String message;
	public BiddingNotStartedException() {
		super();
	}
	public BiddingNotStartedException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String toString() {
		return "BiddingNotStartedException [message=" + message + "]";
	}

}
