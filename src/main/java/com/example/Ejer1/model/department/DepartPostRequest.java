package com.example.Ejer1.model.department;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class DepartPostRequest {

	@NotNull(message = "El id no puede ser Nulo")
	@NotBlank(message = "El id no puede ser Blanco")
	@NotEmpty(message = "El id no puede ser Vacio")
	private int id;
	
	@NotNull(message = "El nombre no puede ser Nulo")
	@NotBlank(message = "El nombre no puede ser Blanco")
	@NotEmpty(message = "El nombre no puede ser Vacio")
    private String name;
	
	@NotNull(message = "La ciudad no puede ser Nulo")
	@NotBlank(message = "La ciudad no puede ser Blanco")
	@NotEmpty(message = "La ciudad no puede ser Vacio")
    private String city;
    
    public DepartPostRequest() {};

	public DepartPostRequest(
			@NotNull(message = "El id no puede ser Nulo") @NotBlank(message = "El id no puede ser Blanco") @NotEmpty(message = "El id no puede ser Vacio") int id,
			@NotNull(message = "El nombre no puede ser Nulo") @NotBlank(message = "El nombre no puede ser Blanco") @NotEmpty(message = "El nombre no puede ser Vacio") String name,
			@NotNull(message = "La ciudad no puede ser Nulo") @NotBlank(message = "La ciudad no puede ser Blanco") @NotEmpty(message = "La ciudad no puede ser Vacio") String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "DepartPostRequest [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	
}
