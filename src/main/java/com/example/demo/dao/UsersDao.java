package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class UsersDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addUser() {
		jdbcTemplate.update("SELECT * FROM INFORMATION_SCHEMA.TABLES");
	}
}
