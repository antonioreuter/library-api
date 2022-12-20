package com.demo.library.domain.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class CustomException extends RuntimeException {
	private final Severity severity;
	private final Issue issue;
	private final String message;

	public CustomException(String message, Severity severity, Issue issue) {
		this.message = message;
		this.severity = severity;
		this.issue = issue;
	}
}
