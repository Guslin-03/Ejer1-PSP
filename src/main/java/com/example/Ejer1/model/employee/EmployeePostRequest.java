package com.example.Ejer1.model.employee;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class EmployeePostRequest {

	@NotNull(message = "El id no puede ser Nulo")
	@NotBlank(message = "El id no puede ser Blanco")
	@NotEmpty(message = "El id no puede ser Vacio")
	private int id;
	
	@NotNull(message = "El nombre no puede ser Nulo")
	@NotBlank(message = "El nombre no puede ser Blanco")
	@NotEmpty(message = "El nombre no puede ser Vacio")
	private String name;
	
	@NotNull(message = "La posición no puede ser Nulo")
	@NotBlank(message = "La posición no puede ser Blanco")
	@NotEmpty(message = "La posición no puede ser Vacio")
	private String position;
	
	@Min(15000)
	@Max(30000)
	private Integer salary;
	
	private Integer bossId;
	private Integer departmentId;
	
	public EmployeePostRequest() {};
	
	public EmployeePostRequest(
			@NotNull(message = "El id no puede ser Nulo") @NotBlank(message = "El id no puede ser Blanco") @NotEmpty(message = "El id no puede ser Vacio") int id,
			@NotNull(message = "El nombre no puede ser Nulo") @NotBlank(message = "El nombre no puede ser Blanco") @NotEmpty(message = "El nombre no puede ser Vacio") String name,
			@NotNull(message = "La posición no puede ser Nulo") @NotBlank(message = "La posición no puede ser Blanco") @NotEmpty(message = "La posición no puede ser Vacio") String position,
			@Min(15000) @Max(30000) Integer salary, Integer bossId, Integer departmentId) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.salary = salary;
		this.bossId = bossId;
		this.departmentId = departmentId;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Integer getBossId() {
		return bossId;
	}
	public void setBossId(Integer bossId) {
		this.bossId = bossId;
	}
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "EmployeePostRequest [name=" + name + ", position=" + position + ", salary=" + salary + ", bossId="
				+ bossId + ", departmentId=" + departmentId + "]";
	}
	
}
