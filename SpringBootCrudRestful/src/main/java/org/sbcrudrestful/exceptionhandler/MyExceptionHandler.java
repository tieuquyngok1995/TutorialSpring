package org.sbcrudrestful.exceptionhandler;

import org.sbcrudrestful.exception.NameSpecialException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(NameSpecialException.class)
	public ResponseEntity<String> handlerName(NameSpecialException e, WebRequest request) {

		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
