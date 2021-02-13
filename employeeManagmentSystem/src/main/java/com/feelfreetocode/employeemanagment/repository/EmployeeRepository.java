package com.feelfreetocode.employeemanagment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feelfreetocode.employeemanagment.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
