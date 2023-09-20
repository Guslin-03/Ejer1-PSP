package com.example.Ejer1.repository.department;

import java.util.List;

import com.example.Ejer1.model.department.DepartDAO;

public interface DepartRepository {

	List<DepartDAO> findAll();
	DepartDAO findById(int id);
	int create(DepartDAO depart);
	int update(DepartDAO depart);
	int deleteById(int id);
	
}
