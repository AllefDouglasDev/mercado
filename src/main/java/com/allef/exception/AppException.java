package com.allef.exception;

public class AppException extends Exception {
	private String title;
	private String message;

	public AppException(String title, String message) {
		super(message);
		this.title = title;
		this.message = message;
	}
	
	public String getTitle() {
		return this.title;
	}

	public String getMessage() {
		return this.message;
	}
}
