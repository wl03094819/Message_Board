package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.MessageJPA;

public interface MessageRespository extends JpaRepository<MessageJPA, Integer> {
    @Autowired
    
    @Query(value = "select * from message ORDER BY id", nativeQuery = true)
    List<MessageJPA> getFindAll();
	
	MessageJPA findByName(String name);
    
}