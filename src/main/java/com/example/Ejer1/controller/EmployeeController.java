package com.example.Ejer1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ejer1.model.Employee;
import com.example.Ejer1.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployee() {
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {
		return employeeService.findById(id);
	}
	
	@PostMapping("employees")
	public int createEmployee(@RequestBody Employee employee) {
		return employeeService.create(employee);
	}
	
	@PutMapping("/employees/{id}")
	public int updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		return employeeService.update(employee);
		
	}
	
	@DeleteMapping("employees/{id}") 
	public int deleteEmployee(@PathVariable("id") int id) {
		return employeeService.deleteById(id);
	}
	
}
