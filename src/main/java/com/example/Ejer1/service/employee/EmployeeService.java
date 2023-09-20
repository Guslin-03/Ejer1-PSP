package com.example.Ejer1.service.employee;

import java.util.List;

import com.example.Ejer1.model.employee.EmployeeDTO;

public interface EmployeeService {

	List<EmployeeDTO> findAll();
	EmployeeDTO findById(int id);
	int create(EmployeeDTO employeeDto);
	int update(EmployeeDTO employeeDto);
	int deleteById(int id);
	EmployeeDTO getEmployeeWithBoss(int id);
	List<EmployeeDTO> getAllEmployeesForCertainDepartment(int id);
	EmployeeDTO getEmployeeWithOurSales(int id);
	int updateEmployeeSalary(int id);
	
}
