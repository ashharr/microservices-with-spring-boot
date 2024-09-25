package com.ashhar.rest.webservices.restful_web_services.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	
	private String message;
	private LocalDateTime timestamp;
	private String details;
	
	public ErrorDetails(String message, LocalDateTime timestamp, String details) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.details = details;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getDetails() {
		return details;
	}
	
}
