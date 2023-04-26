package com.org.studentmanagementsystem.exception;

public class StudentNotFoundException extends RuntimeException {

	private final String messsage;

	public StudentNotFoundException(String messsage) {
		super();
		this.messsage = messsage;
	}

	public String getMesssage() {
		return messsage;
	}
	
}
