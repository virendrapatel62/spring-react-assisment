package com.feelfreetocode.employeemanagment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feelfreetocode.employeemanagment.exceptions.EmployeeNotFoundException;
import com.feelfreetocode.employeemanagment.models.Employee;
import com.feelfreetocode.employeemanagment.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRespository;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return this.employeeRespository.findAll();
	}

	@Override
	public Employee getEmployee(Long id) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		Optional<Employee> optional = this.employeeRespository.findById(id);
		if(optional.isPresent())
			return optional.get();
		
		throw new EmployeeNotFoundException(id);
	}

	@Override
	public void deleteEmployeeById(Long id) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		if (this.employeeRespository.existsById(id))
			this.employeeRespository.deleteById(id);
		else 
			throw new EmployeeNotFoundException(id);

	}
	


	@Override
	public Employee updateEmployee(Employee employee, Long id)throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		if (!this.employeeRespository.existsById(id))
			throw new EmployeeNotFoundException(id);
		
		employee.setId(id);
		return this.employeeRespository.save(employee);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return this.employeeRespository.save(employee);
	}

}
