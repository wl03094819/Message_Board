package com.example.demo;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.services.UserService;


@Controller
public class userController {
	@RequestMapping("/c")
	public String greeting(@RequestParam(value = "title", required = false, defaultValue = "xiao") String title,
			Model model) {
		model.addAttribute("name", title);
		return "index";

	}
	
	@Autowired
	UserService userService;
	
	@GetMapping("/b")
	public String index(Map<String, Object> model) {
		model.put("ID", userService.getUserId());
		return "index";
	}
	
	@GetMapping("/a")
	public String a(Map<String, Object> model) {
		
		return "Message";
	}
	
	
}
