package com.feelfreetocode.employeemanagment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.feelfreetocode.employeemanagment.exceptions.EmployeeNotFoundException;
import com.feelfreetocode.employeemanagment.models.Employee;

@Service
public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public Employee getEmployee(Long id) throws EmployeeNotFoundException;
	public Employee createEmployee(Employee employee);
	public void deleteEmployeeById(Long id) throws EmployeeNotFoundException;
	public Employee updateEmployee(Employee employee , Long id) throws EmployeeNotFoundException;
}
