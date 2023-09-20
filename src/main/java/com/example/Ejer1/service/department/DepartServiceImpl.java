package com.example.Ejer1.service.department;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ejer1.model.department.DepartDAO;
import com.example.Ejer1.model.department.DepartDTO;
import com.example.Ejer1.model.employee.EmployeeDTO;
import com.example.Ejer1.repository.department.DepartRepository;
import com.example.Ejer1.service.employee.EmployeeService;
import com.example.Ejer1.service.sales.SalesService;

@Service
public class DepartServiceImpl implements DepartService{

	@Autowired
	DepartRepository departRepository;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	SalesService salesService;

	@Override
	public List<DepartDTO> findAll() {
		return departDAOListTodepartDTOList(departRepository.findAll());
	}

	@Override
	public DepartDTO findById(int id) {
		return departDAODepartDTO(departRepository.findById(id));
	}

	@Override
	public int create(DepartDTO depart) {
		return departRepository.create(departDTOtoDepartDAO(depart));
	}

	@Override
	public int update(DepartDTO depart) {
		return departRepository.update(departDTOtoDepartDAO(depart));
	}

	@Override
	public int deleteById(int id) {
		return departRepository.deleteById(id);
	}

	@Override
	public List<EmployeeDTO> getAllEmployeesForCertainDepartment(int id) {
		return employeeService.getAllEmployeesForCertainDepartment(id);
	}

	@Override
	public DepartDTO getAllEmployeesForCertainDepartmentWithDepartment(int id) {

		DepartDTO response = findById(id);
		response.setEmployeeDTO(getAllEmployeesForCertainDepartment(id));
		return response;
	}

	@Override
	public DepartDTO getDepartmentByIdWithAllAmountOfSales(int id) {

		DepartDTO departDTO = departDAODepartDTO(departRepository.findById(id));
		departDTO.setTotalSales(salesService.findAllAmountOfSalesFromCertainDepartmentId(id));
		return departDTO;
	}

	//Conversiones
	public DepartDTO departDAODepartDTO(DepartDAO departDAO) {

		return new DepartDTO(
				departDAO.getId(), 
				departDAO.getName(), 
				departDAO.getCity()
				); 

	}

	public List<DepartDTO> departDAOListTodepartDTOList(List<DepartDAO> departDaoList) {

		List<DepartDTO> departDtoList = new ArrayList<DepartDTO>();

		for (DepartDAO departDto : departDaoList) {

			departDtoList.add(departDAODepartDTO( departDto));

		}

		return departDtoList;

	}

	public DepartDAO departDTOtoDepartDAO(DepartDTO departDTO) {

		return new DepartDAO(
				departDTO.getId(), 
				departDTO.getName(), 
				departDTO.getCity()
				); 

	}

}
