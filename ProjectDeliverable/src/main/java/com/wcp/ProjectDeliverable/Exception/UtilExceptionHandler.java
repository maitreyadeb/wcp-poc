package com.wcp.ProjectDeliverable.Exception;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class UtilExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	ExceptionResponse exceptionResponse;
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		exceptionResponse.setTimestamp(new Date());
		exceptionResponse.setMessage(ex.getMessage());
		exceptionResponse.setDetails(request.getDescription(false));
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);	
	}
	
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request) {
		exceptionResponse.setTimestamp(new Date());
		exceptionResponse.setMessage(ex.getMessage());
		exceptionResponse.setDetails(request.getDescription(false));
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);	
	}
}
