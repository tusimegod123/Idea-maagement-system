package com.flhub.ideams.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.flhub.ideams.Services.CountryService;
import com.flhub.ideams.Services.GenderService;
import com.flhub.ideams.models.Gender;


@Controller
public class GenderController {
	
	@Autowired
	GenderService genderService;
	CountryService countryService;

	@PostMapping(value = "/addgender")
	private String saveIdea(@ModelAttribute Gender gender) {
		genderService.save(gender);
		return "redirect:/seeideas";
	}

}
