package com.org.studentmanagementsystem.exception;

public class InvalidAdminException extends RuntimeException {
	
	private final String message;
	
	public InvalidAdminException(String message) {
		super();
		this.message = message;
	}

}
