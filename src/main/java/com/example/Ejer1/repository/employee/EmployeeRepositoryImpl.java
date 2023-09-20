package com.example.Ejer1.repository.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Ejer1.model.employee.EmployeeDAO;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<EmployeeDAO> findAll() {

		try {

			return jdbcTemplate.query(
					"SELECT * FROM employees", 
					BeanPropertyRowMapper.newInstance(EmployeeDAO.class));

		}catch (IncorrectResultSizeDataAccessException e) {

			return null;

		}

	}

	@Override
	public EmployeeDAO findById(int id) {
		return jdbcTemplate.queryForObject(
				"SELECT * FROM employees where ID = ?",
				BeanPropertyRowMapper.newInstance(EmployeeDAO.class),
				id
				);
	}

	@Override
	public int create(EmployeeDAO employee) {
		return jdbcTemplate.update(
				"INSERT INTO employees ( name, position, salary ) VALUES(?, ?, ?)",
				new Object[] { employee.getName(), employee.getPosition(), employee.getSalary()}
				);
	}

	@Override
	public int update(EmployeeDAO employee) {
		return jdbcTemplate.update(
				"UPDATE employees SET name = ?, position = ?, salary = ? WHERE id = ?",
				new Object[] { employee.getName(), employee.getPosition() ,employee.getSalary(), employee.getId()}
				);
	}

	@Override
	public int deleteById(int id) {
		return jdbcTemplate.update(
				"DELETE FROM employees WHERE id=?", 
				id
				);
	}

	@Override
	public List<EmployeeDAO> getAllEmployeesForCertainDepartment(int id) {
		return jdbcTemplate.query(
				"SELECT * FROM ejercicio1.employees where departmentId = ?",
				BeanPropertyRowMapper.newInstance(EmployeeDAO.class),
				id
				);
	}

}
