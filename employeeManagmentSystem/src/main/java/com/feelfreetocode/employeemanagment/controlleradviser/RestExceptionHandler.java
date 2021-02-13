package com.feelfreetocode.employeemanagment.controlleradviser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.feelfreetocode.employeemanagment.errorresponse.EmployeeNotFoundErrorResponse;
import com.feelfreetocode.employeemanagment.errorresponse.ErrorResponse;
import com.feelfreetocode.employeemanagment.errorresponse.MethodArgumentNotValidErrorResponse;
import com.feelfreetocode.employeemanagment.exceptions.EmployeeNotFoundException;
import com.feelfreetocode.employeemanagment.models.Employee;

@ControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		return new ResponseEntity<>(MethodArgumentNotValidErrorResponse.getErrorResponce(ex.getFieldErrors()) ,  HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException ex,WebRequest request) {
		// TODO Auto-generated method stub
		EmployeeNotFoundErrorResponse  errorResponse = new EmployeeNotFoundErrorResponse(ex.getMessage() ,ex.getEmployeeId() ,Employee.class.getName() );
		return new ResponseEntity<>( errorResponse,  HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex,WebRequest request) {
		// TODO Auto-generated method stub
		List<Object> list = new ArrayList<>();
		
		
		return new ResponseEntity<>( new ErrorResponse(ex.getMostSpecificCause().getMessage()),  HttpStatus.BAD_REQUEST);
	}
	
	
}
