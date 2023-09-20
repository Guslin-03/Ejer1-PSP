package com.example.Ejer1.repository.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Ejer1.model.department.DepartDAO;

@Repository
public class DepartRepositoryImpl implements DepartRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<DepartDAO> findAll() {

		try {

			return jdbcTemplate.query("SELECT * from departments", BeanPropertyRowMapper.newInstance(DepartDAO.class));

		}catch (IncorrectResultSizeDataAccessException e) {

			return null;

		}

	}

	@Override
	public DepartDAO findById(int id) {
		return jdbcTemplate.queryForObject(
				"SELECT * FROM departments where ID = ?",
				BeanPropertyRowMapper.newInstance(DepartDAO.class),
				id
				);
	}

	@Override
	public int create(DepartDAO depart) {
		return jdbcTemplate.update(
				"INSERT INTO departments ( name, city ) VALUES(?, ?)",
				new Object[] { depart.getName(), depart.getCity()}
				);
	}

	@Override
	public int update(DepartDAO depart) {
		return jdbcTemplate.update("UPDATE departments SET name = ?, city = ? WHERE id = ?",
				new Object[] { depart.getName(), depart.getCity() , depart.getId()}
				);
	}

	@Override
	public int deleteById(int id) {
		return jdbcTemplate.update("DELETE FROM departments WHERE id=?", id);
	}

}
