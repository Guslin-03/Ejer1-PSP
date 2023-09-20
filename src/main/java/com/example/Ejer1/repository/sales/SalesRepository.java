package com.example.Ejer1.repository.sales;

import java.util.List;

import com.example.Ejer1.model.sales.SalesDAO;

public interface SalesRepository {

	List<SalesDAO> findById(int id);
	int findAllAmountOfSalesFromCertainDepartmentId(int idDepart);
	
}
