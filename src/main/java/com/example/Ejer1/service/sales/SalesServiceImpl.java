package com.example.Ejer1.service.sales;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ejer1.model.sales.SalesDAO;
import com.example.Ejer1.model.sales.SalesDTO;
import com.example.Ejer1.repository.sales.SalesRepository;

@Service
public class SalesServiceImpl implements SalesService{

	@Autowired
	SalesRepository salesRepository;
	
	@Override
	public List<SalesDTO> findSalesByEmployeeId(int idEmployee) {
		return salesDAOListToSalesDTOList(salesRepository.findById(idEmployee));
	}
	
	@Override
	public int findAllAmountOfSalesFromCertainDepartmentId(int idDepart) {
		return salesRepository.findAllAmountOfSalesFromCertainDepartmentId(idDepart);
	}
	
	//Conversiones
	public SalesDTO salesDAOToSalesDTO(SalesDAO salesDAO) {
		
		return new SalesDTO(
				salesDAO.getId(), 
				salesDAO.getSaleDate(), 
				salesDAO.getAmount(), 
				salesDAO.getEmployeeId()
				); 

	}
	
	public List<SalesDTO> salesDAOListToSalesDTOList(List<SalesDAO> salesDAOList) {
		
		List<SalesDTO> salesDTOList = new ArrayList<SalesDTO>();
		
		for (SalesDAO salesDAO : salesDAOList) {
			
			salesDTOList.add(salesDAOToSalesDTO(salesDAO));
			
		}
		
		return salesDTOList;
		
	}
	
}
