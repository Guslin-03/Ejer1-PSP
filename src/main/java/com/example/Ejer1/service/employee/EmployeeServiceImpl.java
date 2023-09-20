package com.example.Ejer1.service.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ejer1.model.employee.EmployeeDAO;
import com.example.Ejer1.model.employee.EmployeeDTO;
import com.example.Ejer1.model.sales.SalesDTO;
import com.example.Ejer1.repository.employee.EmployeeRepository;
import com.example.Ejer1.service.sales.SalesService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	SalesService salesService;

	@Override
	public List<EmployeeDTO> findAll() {
		return employeeDAOListToemployeeDTOList(employeeRepository.findAll());
	}

	@Override
	public EmployeeDTO findById(int id) {
		return employeeDAOemployeeDTO(employeeRepository.findById(id));
	}

	@Override
	public int create(EmployeeDTO employeeDto) {
		return employeeRepository.create(employeeDTOtoemployeeDAO(employeeDto));
	}

	@Override
	public int update(EmployeeDTO employeeDto) {
		return employeeRepository.update(employeeDTOtoemployeeDAO(employeeDto));
	}

	@Override
	public int deleteById(int id) {
		return employeeRepository.deleteById(id);
	}

	@Override
	public EmployeeDTO getEmployeeWithBoss(int id) {

		EmployeeDTO employeeDto = employeeDAOemployeeDTO(employeeRepository.findById(id));

		if (employeeDto.getBossId() != null) {

			EmployeeDTO bossEmployeeDto = employeeDAOemployeeDTO(employeeRepository.findById(employeeDto.getBossId()));

			employeeDto.setBoss(bossEmployeeDto);

		}

		return employeeDto;
	}

	@Override
	public List<EmployeeDTO> getAllEmployeesForCertainDepartment(int id) {	
		return employeeDAOListToemployeeDTOList(employeeRepository.getAllEmployeesForCertainDepartment(id));	
	}

	@Override
	public EmployeeDTO getEmployeeWithOurSales(int id) {

		EmployeeDTO employeeDto = findById(id) ;

		employeeDto.setSales(salesService.findSalesByEmployeeId(id));

		return employeeDto;
	}

	@Override
	public int updateEmployeeSalary(int id) {
		EmployeeDTO employeeDTO = getEmployeeWithOurSales(id);

		int totalAmountOfSales = getTotalAmount(employeeDTO);

		int salaryIncrease = employeeDTO.getSalary();

		if (employeeDTO.getPosition().equals("TRABAJADOR")) {

			if (totalAmountOfSales >= 70000 && totalAmountOfSales < 118000) {

				salaryIncrease += ((salaryIncrease * 5) / 100);

			}else if(totalAmountOfSales >= 118000) {

				salaryIncrease += ((salaryIncrease * 10) / 100);

			}
			
			
			salaryIncrease += 1000;


		}else if(employeeDTO.getPosition().equals("COMERCIAL")) {

			
			if (totalAmountOfSales >= 20000 && totalAmountOfSales < 30000) {

				salaryIncrease += ((salaryIncrease * 3) / 100);

			}else if(totalAmountOfSales >= 30000) {

				salaryIncrease += ((salaryIncrease * 5) / 100);

			}
			
			
			salaryIncrease += 500;
			

		}else {

			salaryIncrease += ((salaryIncrease * 10) / 100);

		}

		employeeDTO.setSalary(salaryIncrease);
		
		return  update(employeeDTO);
	}

	private int getTotalAmount(EmployeeDTO employeeDTO) {

		int totalAmountOfSales = 0;

		for (SalesDTO salesDTO  : employeeDTO.getSales()) {

			totalAmountOfSales += salesDTO.getAmount();

		}

		return totalAmountOfSales;
	}

	//Conversiones
	private EmployeeDTO employeeDAOemployeeDTO(EmployeeDAO employeeDao) {

		return new EmployeeDTO(
				employeeDao.getId(), 
				employeeDao.getName(), 
				employeeDao.getPosition(), 
				employeeDao.getSalary(), 
				employeeDao.getBossId(), 
				employeeDao.getDepartmentId()
				); 

	}

	private List<EmployeeDTO> employeeDAOListToemployeeDTOList(List<EmployeeDAO> employeeDaoList) {

		List<EmployeeDTO> employeeDTOList = new ArrayList<EmployeeDTO>();

		for (EmployeeDAO employeeDAO : employeeDaoList) {

			employeeDTOList.add(employeeDAOemployeeDTO(employeeDAO));

		}

		return employeeDTOList;

	}

	private EmployeeDAO employeeDTOtoemployeeDAO(EmployeeDTO employeeDto) {

		return new EmployeeDAO(
				employeeDto.getId(), 
				employeeDto.getName(), 
				employeeDto.getPosition(), 
				employeeDto.getSalary(), 
				employeeDto.getBossId(), 
				employeeDto.getDepartmentId()
				); 

	}

}
