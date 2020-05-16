package com.cognizant.addressService.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = AddressNotFoundException.class)
	public ResponseEntity<ErrorResponse> userNotFound(AddressNotFoundException exception) {
		ErrorResponse errorresp = new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage());
		return new ResponseEntity<ErrorResponse>(errorresp, HttpStatus.NOT_FOUND);
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = NumberFormatException.class)
	public ResponseEntity<ErrorResponse> numberFormat(NumberFormatException exception) {
		ErrorResponse errorresp = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage().replaceFirst(".*For input string: ", "Pease enter the number"));
		return new ResponseEntity<ErrorResponse>(errorresp, HttpStatus.BAD_REQUEST);
	}
		
	@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
	@ExceptionHandler(value = InvalidDataAccessResourceUsageException.class)
	public ResponseEntity<ErrorResponse> maintainence(InvalidDataAccessResourceUsageException exception) {
		ErrorResponse errorresp = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE.value(), ExceptionMessage.DATABASE.getMessage());
		return new ResponseEntity<ErrorResponse>(errorresp, HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@ResponseStatus(value = HttpStatus.HTTP_VERSION_NOT_SUPPORTED)
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> notEmpty(ConstraintViolationException exception) {
		ErrorResponse errorresp = new ErrorResponse(HttpStatus.HTTP_VERSION_NOT_SUPPORTED.value(), ExceptionMessage.NOTEMPTY.getMessage());
		return new ResponseEntity<ErrorResponse>(errorresp, HttpStatus.HTTP_VERSION_NOT_SUPPORTED);
	}

}
