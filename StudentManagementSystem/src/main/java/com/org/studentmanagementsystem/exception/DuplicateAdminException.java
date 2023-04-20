package com.org.studentmanagementsystem.exception;

public class DuplicateAdminException extends Exception {
	
	private final String message;

	public DuplicateAdminException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
