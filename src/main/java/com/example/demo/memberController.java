package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.dao.MemberRepository;
import com.example.demo.model.*;
import com.example.demo.services.*;

@Controller
public class memberController {
	//透過 @RequestMapping 指定從/會被對應到此hello()方法
	@Autowired
	MemberAccount memberAccount;
	
	@Autowired
	MemberService memberService;
    @RequestMapping("/a")
    public String hello(){
    	memberAccount = new MemberAccount();
    	memberAccount.setPassword("12345678");
    	memberAccount.setEmail("test@gmail.com");
    	memberAccount.setCellphone("0912345789");
    	memberAccount.setAddress("台北市");
    	memberService.addMember(memberAccount);
        return "新增會員成功";
    }
    
//    @GetMapping("/c")
//    public String addMemberPage(){
////    	memberAccount = new MemberAccount();
////    	memberService.addMember(memberAccount);
//
//        return "addMemberPage";
//    }
    
    @Autowired
	MemberRepository memberRepository;
	
	@Autowired
	DataSource dataSource;
	 

	@GetMapping("/d")
    public String addMemberPage(){

		List<MemberAccountJPA> memberAccountJPA= new ArrayList<MemberAccountJPA>();
		memberAccountJPA = memberRepository.findAll();

		for(int i=0;i<memberAccountJPA.size();i++){
			System.out.println(memberAccountJPA.get(i).getId());
		}
        return "addMemberPage";
    }
	
	@GetMapping("/login")
    public String login(@ModelAttribute MemberAccountJPA memberAccountJPA){

        return "login";
    }
	
	@PostMapping("/doLogin")
    public String doLogin(@ModelAttribute MemberAccountJPA memberAccountJPA){
		//System.out.println(memberRepository.findCheckMemberAccount(memberAccountJPA.getEmail(), memberAccountJPA.getPassword()));

        return "welcome";
    }
}