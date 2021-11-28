package com.example.jwt.entity;

public class OAuthException extends Exception {
	
	private String message;
	private Integer statusCode;
	
	public OAuthException(String message, Integer statusCode) {
		this.message = message;
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

}
