package com.feelfreetocode.employeemanagment.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feelfreetocode.employeemanagment.exceptions.EmployeeNotFoundException;
import com.feelfreetocode.employeemanagment.models.Employee;
import com.feelfreetocode.employeemanagment.services.EmployeeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeServiceImpl;
	
	@GetMapping()
	public List<Employee> getAllEmployees() {
		return this.employeeServiceImpl.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id) throws EmployeeNotFoundException {
		return this.employeeServiceImpl.getEmployee(id);
	}
	
	
	@PostMapping()
	public Employee createEmployee(@RequestBody @Valid Employee  employee) {
		return this.employeeServiceImpl.createEmployee(employee);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@RequestBody @Valid Employee  employee 
			, @PathVariable Long id)  throws EmployeeNotFoundException{
		return this.employeeServiceImpl.updateEmployee(employee, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Long id)  throws EmployeeNotFoundException{
		this.employeeServiceImpl.deleteEmployeeById(id);
	}
}









