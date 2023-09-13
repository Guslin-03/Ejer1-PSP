package com.example.Ejer1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ejer1.model.Depart;
import com.example.Ejer1.service.DepartService;

@RestController
public class DepartController {
	
	@Autowired
	DepartService departService;
	
	@GetMapping("/departments")
	public List<Depart> getDepart() {
		
		return departService.findAll();
		
	}
	
	@GetMapping("/departments/{id}")
	public Depart getDepart(@PathVariable("id") int id) {
	
		return departService.findById(id);
		
	}
	
	@PostMapping("departments")
	public int createDepart(@RequestBody Depart depart) {
		return departService.create(depart);
		
	}
	
	@PutMapping("/departments/{id}")
	public int updateDepart(@PathVariable("id") int id, @RequestBody Depart depart) {
		return departService.update(depart);
		
	}
	
	@DeleteMapping("departments/{id}") 
	public int deleteDepat(@PathVariable("id") int id) {

		return departService.deleteById(id);
		
	}

}
