package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.dao.MessageRespository;
import com.example.demo.model.MessageJPA;
import com.example.demo.services.MessageServices;

@Controller
public class messageController {
	
	@Autowired
	MessageServices messageServices;

	@GetMapping("/Msg")
	public String messagePage(Model model) {
		List<MessageJPA> messageList = messageServices.getMessageList();
		model.addAttribute("messageList", messageList);
		model.addAttribute("message", new MessageJPA());
		return "Message";
	}

	//Add method
	@PostMapping("/Msg")
	public String messageSubmit(@ModelAttribute MessageJPA message, Model model) {
		messageServices.addMessage(message.getName(), message.getContext());
		
		return "redirect:/Msg";
	}
	
	//Delete method
	@PostMapping("/Msg/Del{MessageID}")
	public String deletePost(@PathVariable("MessageID") Integer MsgID) {
		messageServices.deleteMessage(MsgID);
		return "redirect:/Msg";
	}

}
