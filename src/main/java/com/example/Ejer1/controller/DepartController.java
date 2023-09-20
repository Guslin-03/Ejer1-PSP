package com.example.Ejer1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ejer1.model.department.DepartDTO;
import com.example.Ejer1.model.department.DepartGetRequest;
import com.example.Ejer1.model.department.DepartPostRequest;
import com.example.Ejer1.model.department.DepartSalesGetRequest;
import com.example.Ejer1.model.employee.EmployeeDTO;
import com.example.Ejer1.model.employee.EmployeeGetRequest;
import com.example.Ejer1.service.department.DepartService;

@RestController
public class DepartController {
	
	@Autowired
	DepartService departService;
	
	@GetMapping("/departments")
	public List<DepartGetRequest> getDepart() {
		return departDtoListToDepartGetRequestList(departService.findAll());
	}
	
	@GetMapping("/departments/{id}")
	public DepartGetRequest getDepart(@PathVariable("id") int id) {
		return departDTOToDepartGetRequest(departService.findById(id));
	}
	
	@PostMapping("departments")
	public int createDepart(@RequestBody DepartPostRequest departPostRequest) {
		return departService.create(departPostRequestToDepartDTO(departPostRequest));
	}
	
	@PutMapping("/departments/{id}")
	public int updateDepart(@PathVariable("id") int id, @RequestBody DepartPostRequest departPostRequest) {
		return departService.update(departPostRequestToDepartDTO(departPostRequest));
	}
	
	@DeleteMapping("departments/{id}") 
	public int deleteDepat(@PathVariable("id") int id) {
		return departService.deleteById(id);
	}
	
	@GetMapping("/departments/{id}/employees")
	public List<EmployeeGetRequest> getAllEmployeesForCertainDepartment(@PathVariable("id") int id) {
		return employeeDtoListToEmployeeGetRequestList(departService.getAllEmployeesForCertainDepartment(id));
	}
	
	@GetMapping("/departments/{id}/expandido")
	public DepartGetRequest getAllEmployeesForCertainDepartmentWithDepartment(@PathVariable("id") int id) {
		return departDTOToDepartGetRequest(departService.getAllEmployeesForCertainDepartmentWithDepartment(id));
	}
	
	@GetMapping("/departments/{id}/sales")
	public DepartSalesGetRequest getDepartmentByIdWithAllSales(@PathVariable("id") int id) {
		return departDTOToDepartSalesGetRequest(departService.getDepartmentByIdWithAllAmountOfSales(id));
	}
	
	//Conversiones
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
	
	public List<EmployeeGetRequest> employeeDtoListToEmployeeGetRequestList(List<EmployeeDTO> employeeDtoList) {
		
		List<EmployeeGetRequest> employeeGetRequest = new ArrayList<EmployeeGetRequest>();
		
		for (EmployeeDTO employeeDTO : employeeDtoList) {
			
			employeeGetRequest.add(employeeDTOToEmployeeGetRequest(employeeDTO));
			
		}
		
		return employeeGetRequest;
		
	}
	
	public DepartDTO departPostRequestToDepartDTO(DepartPostRequest departPostRequest) {

		return new DepartDTO(
				departPostRequest.getId(), 
				departPostRequest.getName(), 
				departPostRequest.getCity()
				); 

	}
	
	public DepartGetRequest departDTOToDepartGetRequest(DepartDTO departDTO) {

		return new DepartGetRequest(
				departDTO.getId(), 
				departDTO.getName(), 
				departDTO.getCity()
				); 

	}
	
	public DepartSalesGetRequest departDTOToDepartSalesGetRequest(DepartDTO departDTO) {

		return new DepartSalesGetRequest(
				departDTO.getId(), 
				departDTO.getName(), 
				departDTO.getCity(),
				departDTO.getTotalSales()
				); 

	}
	
	public List<DepartGetRequest> departDtoListToDepartGetRequestList(List<DepartDTO> DepartDTOList) {
		
		List<DepartGetRequest> departGetRequest = new ArrayList<DepartGetRequest>();
		
		for (DepartDTO departDTO : DepartDTOList) {
			
			departGetRequest.add(departDTOToDepartGetRequest(departDTO));
			
		}
		
		return departGetRequest;
		
	}
	
}
