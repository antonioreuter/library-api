package com.demo.library.api.v1.controllers;

import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Log
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({Exception.class, RuntimeException.class})
	public ResponseEntity<String> handleException(Exception e) {
		log.info(e.getMessage());
		return ResponseEntity.badRequest().body(e.getMessage());
	}


}
