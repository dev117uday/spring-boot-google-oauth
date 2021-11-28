package com.example.jwt.exception;

import com.example.jwt.entity.ErrorMessage;
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
	public ResponseEntity<ErrorMessage> ResponseEntityExceptionHandler(OAuthException exception) {

		Integer exceptionStatus = exception.getStatusCode();

		// TODO : handle exception for all status code
		
		if (exceptionStatus == 400) {
			ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
			return ResponseEntity.status(errorMessage.getStatus()).body(errorMessage);
		}

		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, "stupid programmer");
		return ResponseEntity.status(errorMessage.getStatus()).body(errorMessage);

	}
}
