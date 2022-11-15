package com.squad33.api.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.squad33.api.error.ResourceAlreadyExistsException;
import com.squad33.api.error.ResourceNotFoundException;
import com.squad33.api.error.details.ResourceAlreadyExistsDetails;
import com.squad33.api.error.details.ResourceNotFoundDetails;

@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfException) {
		ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.builder().timestamp(new Date().getTime())
				.title("Resource not found").detail(rnfException.getMessage()).status(HttpStatus.NOT_FOUND.value())
				.developerMessage(rnfException.getClass().getName()).build();
		return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public ResponseEntity<?> handleResourceAlreadyExistsException(ResourceAlreadyExistsException raeException) {
		ResourceAlreadyExistsDetails raeDetails = ResourceAlreadyExistsDetails.builder().timestamp(new Date().getTime())
				.title("Resource already exists").detail(raeException.getMessage()).status(HttpStatus.CONFLICT.value())
				.developerMessage(raeException.getClass().getName()).build();
		return new ResponseEntity<>(raeDetails, HttpStatus.CONFLICT);
	}
}