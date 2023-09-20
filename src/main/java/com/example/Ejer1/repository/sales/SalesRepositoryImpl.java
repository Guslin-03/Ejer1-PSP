package com.example.Ejer1.repository.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Ejer1.model.sales.SalesDAO;

@Repository
public class SalesRepositoryImpl implements SalesRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<SalesDAO> findById(int id) {
		return jdbcTemplate.query(
				"SELECT * FROM sales where employeeID = ?",
				BeanPropertyRowMapper.newInstance(SalesDAO.class),
				id
				);
	}

	@Override
	public int findAllAmountOfSalesFromCertainDepartmentId(int idDepart) {

		return (int) jdbcTemplate.queryForObject("SELECT sum(sales.amount) as totalAmount FROM employees\r\n"
				+ "JOIN sales ON sales.employeeId =  employees.id\r\n"
				+ "where employees.departmentId = ?\r\n"
				+ "GROUP BY employees.departmentId\r\n"
				+ ";", 
				Integer.class,
				idDepart
				);
	}

}
