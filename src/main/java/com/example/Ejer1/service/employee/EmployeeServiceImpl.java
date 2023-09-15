package com.example.Ejer1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ejer1.model.Employee;
import com.example.Ejer1.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {
		return employeeRepository.findById(id);
	}

	@Override
	public int create(Employee employee) {
		return employeeRepository.create(employee);
	}

	@Override
	public int update(Employee employee) {
		return employeeRepository.update(employee);
	}

	@Override
	public int deleteById(int id) {
		return employeeRepository.deleteById(id);
	}


	
}
