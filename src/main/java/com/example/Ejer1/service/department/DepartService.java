package com.example.Ejer1.service.department;

import java.util.List;

import com.example.Ejer1.model.department.DepartDTO;
import com.example.Ejer1.model.employee.EmployeeDTO;

public interface DepartService {

	List<DepartDTO> findAll();
	DepartDTO findById(int id);
	int create(DepartDTO depart);
	int update(DepartDTO depart);
	int deleteById(int id);
	List<EmployeeDTO> getAllEmployeesForCertainDepartment(int id);
	DepartDTO getAllEmployeesForCertainDepartmentWithDepartment(int id);
	DepartDTO getDepartmentByIdWithAllAmountOfSales(int id);
	
	
}
