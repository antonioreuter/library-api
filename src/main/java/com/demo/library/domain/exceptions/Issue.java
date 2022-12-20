package com.demo.library.domain.exceptions;

public enum Issue {
	RESOURCE_NOT_FOUND("resource-not-found", "Resource not found");

	private String code;
	private String message;

	Issue(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}

	public String toString() {
		return String.format("%s - %s", this.code, this.message);
	}
}
