package com.mock.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mock.project.service.TeacherService;

@Controller
public class MainController {
	@Autowired
	private TeacherService teacherService;
	
	@GetMapping("/")
	public String index() {		
		return "index";
	}
	
	@GetMapping("/admin") 
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/403")
	public String accessDenied() {
		return "403";
	}
	
	@GetMapping("/login") 
	public String getLogin() {
		return "login";
	}
	
	@GetMapping("/main-page")
	public String loginIndex() {
		return "loginIndex";
	}
	
	@GetMapping("/chem")
	public String chem() {
		return "chem";
	}
}
