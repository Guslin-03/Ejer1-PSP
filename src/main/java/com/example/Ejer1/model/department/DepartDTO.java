package com.example.Ejer1.model.department;

import java.util.List;

import com.example.Ejer1.model.employee.EmployeeDTO;

public class DepartDTO {

	private int id;
    private String name;
    private String city;
    private List<EmployeeDTO> employeeDTO;
    private int totalSales;
    
    public DepartDTO() {};
    
	public DepartDTO(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}
    
	public DepartDTO(int id, String name, String city, int totalSales) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.totalSales = totalSales;
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

	public List<EmployeeDTO> getEmployeeDTO() {
		return employeeDTO;
	}

	public void setEmployeeDTO(List<EmployeeDTO> employeeDTO) {
		this.employeeDTO = employeeDTO;
	}
	
	public int getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}

	@Override
	public String toString() {
		return "DepartDTO [id=" + id + ", name=" + name + ", city=" + city + ", employeeDTO=" + employeeDTO + "]";
	}
    
}
