package com.feelfreetocode.employeemanagment.errorresponse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MethodArgumentNotValidErrorResponse extends ErrorResponse {
	private String objectName;
	private Object rejectedValue;
	private String field;
	private String message;
	
	public static List<ErrorResponse> getErrorResponce(List<FieldError> errs){
		List<ErrorResponse>  errors = new ArrayList<>();
		
		errs.forEach(e->{
			errors.add(new MethodArgumentNotValidErrorResponse(e.getObjectName(),
					e.getRejectedValue(), e.getField(), e.getDefaultMessage()));
		});
		
		return errors;
	}
	
	
}
