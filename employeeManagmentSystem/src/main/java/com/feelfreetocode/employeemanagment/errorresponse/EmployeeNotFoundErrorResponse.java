package com.feelfreetocode.employeemanagment.errorresponse;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeNotFoundErrorResponse extends ErrorResponse{
	private String message;
	private Long employeeId;
	private Object object;
}
