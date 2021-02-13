package com.feelfreetocode.employeemanagment.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
@Entity(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Email
	@NotBlank
	@Column(unique = true)
	private String email ;
	
	@Length(min = 3 , max = 40)
	@NotBlank
	@Column
	private String firstName;
	
	@Length(min = 3 , max = 40)
	@NotBlank
	@Column
	private String lastName;
}




























