package com.example.Ejer1.service;

import java.util.List;

import com.example.Ejer1.model.Depart;

public interface DepartService {

	List<Depart> findAll();
	Depart findById(int id);
	int create(Depart depart);
	int update(Depart depart);
	int deleteById(int id);
	
	
}
