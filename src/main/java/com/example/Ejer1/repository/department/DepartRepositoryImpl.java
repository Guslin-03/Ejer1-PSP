package com.example.Ejer1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Ejer1.model.Depart;

@Repository
public class DepartRepositoryImpl implements DepartRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Depart> findAll() {

		try {

			return jdbcTemplate.query("SELECT * from departments", BeanPropertyRowMapper.newInstance(Depart.class));

		}catch (IncorrectResultSizeDataAccessException e) {

			return null;

		}

	}

	@Override
	public Depart findById(int id) {
		return jdbcTemplate.queryForObject(
				"SELECT * FROM departments where ID = ?",
				BeanPropertyRowMapper.newInstance(Depart.class),
				id
				);
	}

	@Override
	public int create(Depart depart) {
		return jdbcTemplate.update(
				"INSERT INTO departments ( name, city ) VALUES(?, ?)",
				new Object[] { depart.getName(), depart.getCity()}
				);
	}

	@Override
	public int update(Depart depart) {
		return jdbcTemplate.update("UPDATE departments SET name = ?, city = ? WHERE id = ?",
				new Object[] { depart.getName(), depart.getCity() , depart.getId()}
				);
	}

	@Override
	public int deleteById(int id) {
		return jdbcTemplate.update("DELETE FROM departments WHERE id=?", id);
	}

}
