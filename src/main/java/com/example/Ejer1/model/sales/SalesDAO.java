package com.example.Ejer1.model.sales;

import java.util.Date;

public class SalesDAO {
	
	private int id;
	private Date saleDate;
	private int amount;
	private int employeeId;
	
	public SalesDAO() {};
	
	public SalesDAO(int id, Date date, int amount, int employeeId) {
		super();
		this.id = id;
		this.saleDate = date;
		this.amount = amount;
		this.employeeId = employeeId;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getSaleDate() {
		return saleDate;
	}
	
	public void setSaleDate(Date date) {
		this.saleDate = date;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "Sales [id=" + id + ", date=" + saleDate + ", amount=" + amount + ", employeeId=" + employeeId + "]";
	}
	
}
