package com.demo.library.domain.exceptions;

public class ResourceNotFoundException extends CustomException {
	public ResourceNotFoundException(String message) {
		super(message, Severity.ERROR, Issue.RESOURCE_NOT_FOUND);
	}
}
