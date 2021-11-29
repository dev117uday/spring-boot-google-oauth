package com.example.jwt.exception;

import com.example.jwt.entity.OAuthException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(OAuthException.class)
	public ResponseEntity<String> ResponseEntityExceptionHandler(OAuthException exception) {

		Integer exceptionStatus = exception.getStatusCode();
		// TODO : handle exception for all status code
		if (exceptionStatus == 400) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("bad request");
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("stupid programmer");
	}
}
