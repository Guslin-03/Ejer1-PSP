package com.example.Ejer1.model.employee;

import java.util.List;

import com.example.Ejer1.model.sales.SalesDTO;

public class EmployeeSalesGetRequest {

	private int id;
	private String name;
	private String position;
	private Integer salary;
	private Integer bossId;
	private Integer departmentId;
	private List<SalesDTO> saleDTOList;
	
	public EmployeeSalesGetRequest() {};
	
	public EmployeeSalesGetRequest(int id, String name, String position, Integer salary, Integer bossId,
			Integer departmentId, List<SalesDTO> saleDTOList) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.salary = salary;
		this.bossId = bossId;
		this.departmentId = departmentId;
		this.saleDTOList = saleDTOList;
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
	public List<SalesDTO> getSaleDTOList() {
		return saleDTOList;
	}
	public void setSaleDTOList(List<SalesDTO> saleDTOList) {
		this.saleDTOList = saleDTOList;
	}

	@Override
	public String toString() {
		return "EmployeeSalesGetRequest [id=" + id + ", name=" + name + ", position=" + position + ", salary=" + salary
				+ ", bossId=" + bossId + ", departmentId=" + departmentId + ", saleDTOList=" + saleDTOList + "]";
	}
	
}
