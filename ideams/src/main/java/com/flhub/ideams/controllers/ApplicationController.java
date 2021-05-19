package com.flhub.ideams.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ApplicationController {
	
    @GetMapping("/")
	public String indexPage(){
		return "index";
	}

	@GetMapping("/login")
	public String homePage() {
		return "login";
	}
	
	@GetMapping("/welcome")
	public String WelcomePage() {
		return "welcome";
	}
	
	@GetMapping("/userhome")
	public String userHomePage() {
		return "userhome";

	}
	
	

}
