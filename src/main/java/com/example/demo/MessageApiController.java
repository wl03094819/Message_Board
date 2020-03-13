package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MessageJPA;
import com.example.demo.services.MessageServices;

@RestController
@RequestMapping("/MessageApi")
public class MessageApiController {
	@Autowired
	MessageServices messageServices;
	
	@RequestMapping(method = RequestMethod.GET)
	 public List<MessageJPA> read() {
		return messageServices.getMessageList();
	 }
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	 public void update(@RequestBody MessageJPA messageJPA) {
		messageServices.addMessage(messageJPA.getName(), messageJPA.getContext());
	 }	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	 public void delete(@PathVariable Integer id) {
		messageServices.deleteMessage(id); 
		 
	 }	
	
}
