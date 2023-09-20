package com.example.Ejer1.model.employee;

public class EmployeeGetRequest {

	private int id;
	private String name;
	private String position;
	private Integer salary;
	private Integer bossId;
	private Integer departmentId;
	
	public EmployeeGetRequest() {}

	public EmployeeGetRequest(int id, String name, String position, Integer salary, Integer bossId,
			Integer departmentId) {
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
		return "EmployeeGetRequest [id=" + id + ", name=" + name + ", position=" + position + ", salary=" + salary
				+ ", bossId=" + bossId + ", departmentId=" + departmentId + "]";
	}
	
}
