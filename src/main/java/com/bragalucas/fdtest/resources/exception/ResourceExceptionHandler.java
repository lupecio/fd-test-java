package com.bragalucas.fdtest.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {
		ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação.", System.currentTimeMillis());
		
		for (FieldError err: e.getBindingResult().getFieldErrors()) {
			error.addError(err.getField(), err.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler
	public ResponseEntity<StandardError> validation(PasswordConfirmationException e, HttpServletRequest request) {
		ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação.", System.currentTimeMillis());
		
		error.addError("confirmPassword", "Confirmação de senha incorreta.");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler
	public ResponseEntity<StandardError> validation(EmailExistsException e, HttpServletRequest request) {
		ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro de validação.", System.currentTimeMillis());
		
		error.addError("email", "Email já está sendo utilizado.");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
