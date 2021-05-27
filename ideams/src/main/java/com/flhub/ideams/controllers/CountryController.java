package com.flhub.ideams.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.flhub.ideams.Services.CountryService;
import com.flhub.ideams.Services.GenderService;
import com.flhub.ideams.Services.RoleService;
import com.flhub.ideams.models.Country;



@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:3001" })
public class CountryController {
	@Autowired CountryService countryService;
	@Autowired GenderService genderService;
	@Autowired RoleService roleService;
	
	
	@PostMapping(value = "/addcountry")
	private Country saveIdea(@ModelAttribute Country country) {
	  return	countryService.save(country);
		
	}
	
	// @PutMapping(value="/country/edit/{country_id}")
	// private Optional<Country> editCountry(@RequestBody Integer country, @PathVariable Integer country_id) {
	// 	return 	countryService.findById(country);
		
	// }

	@GetMapping(path = "/country")
	public List<Country> getCountry(){
		return countryService.findAll();
	}

	

}
