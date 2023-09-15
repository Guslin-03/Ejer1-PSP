package com.example.Ejer1.repository;

import java.util.List;

import com.example.Ejer1.model.Depart;

public interface DepartRepository {

	List<Depart> findAll();
	Depart findById(int id);
	int create(Depart depart);
	int update(Depart depart);
	int deleteById(int id);
	
}
