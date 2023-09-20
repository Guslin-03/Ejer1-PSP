package com.example.Ejer1.service.sales;

import java.util.List;

import com.example.Ejer1.model.sales.SalesDTO;

public interface SalesService {

	List<SalesDTO> findSalesByEmployeeId(int id);
	int findAllAmountOfSalesFromCertainDepartmentId(int idDepart);

}
