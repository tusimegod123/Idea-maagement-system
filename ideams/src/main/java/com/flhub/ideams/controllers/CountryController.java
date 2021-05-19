package com.flhub.ideams.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.flhub.ideams.Services.CountryService;
import com.flhub.ideams.Services.GenderService;
import com.flhub.ideams.Services.RoleService;
import com.flhub.ideams.models.Country;



@Controller
public class CountryController {
	@Autowired CountryService countryService;
	@Autowired GenderService genderService;
	@Autowired RoleService roleService;
	
	
	@PostMapping(value = "/addcountry")
	private String saveIdea(@ModelAttribute Country country) {
		countryService.save(country);
		return "redirect:/seeideas";
	}
	
//	@PutMapping(value="/country/edit/{country_id}")
//	private Country editCountry(@ModelAttribute Country country) {
//		countryService.findAllById(country);
//		return country;
//	}

	

}
