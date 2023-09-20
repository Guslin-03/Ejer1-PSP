package com.example.Ejer1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ejer1.model.employee.EmployeePostRequest;
import com.example.Ejer1.model.employee.EmployeeSalesGetRequest;
import com.example.Ejer1.model.employee.EmployeeDTO;
import com.example.Ejer1.model.employee.EmployeeGetRequest;
import com.example.Ejer1.service.employee.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeGetRequest>> getEmployee() {
		return new ResponseEntity<>(employeeDtoListToEmployeeGetRequestList(employeeService.findAll()), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeGetRequest> getEmployee(@PathVariable("id") int id) {
		EmployeeGetRequest employeeGetRequest = employeeDTOToEmployeeGetRequest(employeeService.findById(id));
		return new ResponseEntity<>(employeeGetRequest, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("employees")
	public ResponseEntity<?> createEmployee(@RequestBody EmployeePostRequest employeePostRequest) {
		employeeService.create(employeePostRequestToEmployeeDTO(employeePostRequest));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable("id") int id, @RequestBody EmployeePostRequest employeePostRequest) {
		employeePostRequest.setId(id);
		employeeService.update(employeePostRequestToEmployeeDTO(employeePostRequest));
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("employees/{id}") 
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("employees/{id}/boss")
	public ResponseEntity<EmployeeGetRequest> getEmployeeWithBoss(@PathVariable("id") int id) {
		return new ResponseEntity<>(employeeDTOToEmployeeGetRequest(employeeService.getEmployeeWithBoss(id)),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/employees/{id}/sales")
	public ResponseEntity<EmployeeSalesGetRequest> getEmployeeWithOurSales(@PathVariable("id") int id) {
		EmployeeSalesGetRequest employeeSalesGetRequest = employeeDTOToEmployeeSalesGetRequest(employeeService.getEmployeeWithOurSales(id));
		return new ResponseEntity<>(employeeSalesGetRequest, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/employees/{id}/salaryIncrease")
	public ResponseEntity<?> updateEmployeeSalary(@PathVariable("id") int id) {
		return new ResponseEntity<>(employeeService.updateEmployeeSalary(id),HttpStatus.NO_CONTENT);
	}
	
	//Conversiones
	public EmployeeDTO employeePostRequestToEmployeeDTO(EmployeePostRequest employeePostRequest) {

		return new EmployeeDTO(
				employeePostRequest.getId(), 
				employeePostRequest.getName(), 
				employeePostRequest.getPosition(), 
				employeePostRequest.getSalary(), 
				employeePostRequest.getBossId(), 
				employeePostRequest.getDepartmentId()
				); 

	}
	
	public EmployeeGetRequest employeeDTOToEmployeeGetRequest(EmployeeDTO employeeDto) {

		return new EmployeeGetRequest(
				employeeDto.getId(), 
				employeeDto.getName(), 
				employeeDto.getPosition(), 
				employeeDto.getSalary(), 
				employeeDto.getBossId(), 
				employeeDto.getDepartmentId()
				); 

	}
	
	public EmployeeSalesGetRequest employeeDTOToEmployeeSalesGetRequest(EmployeeDTO employeeDto) {
		
		return new EmployeeSalesGetRequest(
				employeeDto.getId(), 
				employeeDto.getName(), 
				employeeDto.getPosition(), 
				employeeDto.getSalary(), 
				employeeDto.getBossId(), 
				employeeDto.getDepartmentId(),
				employeeDto.getSales()
				); 
		
	}
	
	public List<EmployeeGetRequest> employeeDtoListToEmployeeGetRequestList(List<EmployeeDTO> employeeDtoList) {
		
		List<EmployeeGetRequest> employeeGetRequest = new ArrayList<EmployeeGetRequest>();
		
		for (EmployeeDTO employeeDTO : employeeDtoList) {
			
			employeeGetRequest.add(employeeDTOToEmployeeGetRequest(employeeDTO));
			
		}
		
		return employeeGetRequest;
		
	}
	
}
