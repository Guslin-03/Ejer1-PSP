package com.example.Ejer1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Ejer1.model.Depart;
import com.example.Ejer1.repository.DepartRepository;

@Service
public class DepartServiceImpl implements DepartService{

	@Autowired
	DepartRepository departRepository;

	@Override
	public List<Depart> findAll() {
		return departRepository.findAll();
	}

	@Override
	public Depart findById(int id) {
		return departRepository.findById(id);
	}

	@Override
	public int create(Depart depart) {
		return departRepository.create(depart);
	}
	
	@Override
	public int update(Depart depart) {
		return departRepository.update(depart);
	}
	
	@Override
	public int deleteById(int id) {
		return departRepository.deleteById(id);
	}

}
