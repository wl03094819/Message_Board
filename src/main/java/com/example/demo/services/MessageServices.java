package com.example.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MessageRespository;
import com.example.demo.model.MessageJPA;

@Service
public class MessageServices {
	@Autowired
	MessageRespository messageRespository;
	
	public List<MessageJPA> getMessageList()
	{
		return messageRespository.getFindAll();
	}
	
	public void addMessage(String name,String context) {
		MessageJPA messageJPA = new MessageJPA();
		messageJPA.setName(name);
		messageJPA.setContext(context);
		messageJPA.setDate(new Date());
		messageRespository.save(messageJPA);
	}
	
	public void deleteMessage(Integer messageID) {
		messageRespository.deleteById(messageID);
	}

}
