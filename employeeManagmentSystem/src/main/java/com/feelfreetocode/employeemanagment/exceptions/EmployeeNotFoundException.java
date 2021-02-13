package com.feelfreetocode.employeemanagment.exceptions;

import lombok.Data;

@Data

public class EmployeeNotFoundException extends Exception{
	private Long employeeId ;
	public EmployeeNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeNotFoundException(Long id) {
		
		this("Employee Not Found with id - " + id);
		this.employeeId = id;
		
	}
	
	public EmployeeNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
