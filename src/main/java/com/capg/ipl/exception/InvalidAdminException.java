package com.capg.ipl.exception;

public class InvalidAdminException extends Exception{
	private String message;
	public InvalidAdminException() {
		super();
	}
	public InvalidAdminException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String toString() {
		return "InvalidAdminException [message=" + message + "]";
	}
	
	

}
