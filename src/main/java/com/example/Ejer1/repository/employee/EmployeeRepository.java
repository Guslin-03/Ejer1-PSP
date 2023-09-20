package com.example.Ejer1.repository.employee;

import java.util.List;

import com.example.Ejer1.model.employee.EmployeeDAO;

public interface EmployeeRepository {

	List<EmployeeDAO> findAll();
	EmployeeDAO findById(int id);
	int create(EmployeeDAO employeeDao);
	int update(EmployeeDAO employeeDao);
	int deleteById(int id);
	List<EmployeeDAO> getAllEmployeesForCertainDepartment(int id);
	
}
