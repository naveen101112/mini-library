package com.example.demo.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth.getName().equals("admin@gmail.com"))
			return "admin";
		return "index";
	}
	
	@RequestMapping("/defect-details")
	public String defectDetails() {
	    return "welcome";
	}
	
	@RequestMapping("/test")
	public String test() {
	    return "test";
	}
	
}
