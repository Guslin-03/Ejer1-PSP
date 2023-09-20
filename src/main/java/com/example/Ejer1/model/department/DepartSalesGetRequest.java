package com.example.Ejer1.model.department;

public class DepartSalesGetRequest {

	private int id;
    private String name;
    private String city;
    private int totalSales;
    
    public DepartSalesGetRequest() {};

	public DepartSalesGetRequest(int id, String name, String city, int totalSales) {
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

	public int getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	
	@Override
	public String toString() {
		return "DepartSalesGetRequest [id=" + id + ", name=" + name + ", city=" + city + ", totalSales=" + totalSales
				+ "]";
	}

	
}
