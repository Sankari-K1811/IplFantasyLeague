package com.capg.ipl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/home")
	public String method1() {
		return "Welcome to IPL fantasy league";
	}
	
	

}
