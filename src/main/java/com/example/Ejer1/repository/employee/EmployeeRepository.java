package com.example.Ejer1.repository;

import java.util.List;

import com.example.Ejer1.model.Employee;

public interface EmployeeRepository {

	List<Employee> findAll();
	Employee findById(int id);
	int create(Employee employee);
	int update(Employee employee);
	int deleteById(int id);
	
}
