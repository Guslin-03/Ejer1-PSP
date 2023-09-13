package com.example.Ejer1.service;

import java.util.List;

import com.example.Ejer1.model.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	Employee findById(int id);
	int create(Employee employee);
	int update(Employee employee);
	int deleteById(int id);
	
	
}
