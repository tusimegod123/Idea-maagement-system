package com.flhub.ideams.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.flhub.ideams.Repository.RoleRepository;
import com.flhub.ideams.Services.CountryService;
import com.flhub.ideams.Services.GenderService;
import com.flhub.ideams.Services.UserService;
import com.flhub.ideams.models.Country;
import com.flhub.ideams.models.Gender;
import com.flhub.ideams.models.Role;
import com.flhub.ideams.models.User;


@Controller
public class UserController {
 
    @Autowired
    private UserService service;
     
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired GenderService genderService;
	@Autowired CountryService countryService;
    
    @GetMapping("/admin")
    public String viewAdminPage () {
    	return "admin";
    }
    
    @GetMapping("/user")
    public String viewUserPage () {
    	return "user";
    }
    
    @GetMapping("/register")
	public String viewRegister(Model model) {    	 
    	List<Role> roles = (List<Role>) roleRepository.findAll();
        List<Country> countries = countryService.findAll();
		List<Gender> genders = genderService.findAll();
    	model.addAttribute("allRoles", roles);
    	model.addAttribute("user", new User());
		model.addAttribute("onescountry", countries);
		model.addAttribute("onesgender", genders);
		model.addAttribute("onesrole", roles);
		//model.addAttribute("user", new User());  
		return "register";

	}
    
    // @PostMapping("/save")
    // 	private String saveuser(@ModelAttribute User user) {
    // 	service.save(user);
    // 	return "welcome";
    		
    	
    // }

    //creating post mapping that post the user details in the database
    @PostMapping("/save")
    private String saveuser(@ModelAttribute User user) {
    service.save(user);
    return "login";
        
    
}
     
    @GetMapping("/users/new")
    public ModelAndView newUser() {
        User user = new User();
        ModelAndView mav = new ModelAndView("user_form");
        mav.addObject("user", user);
         
        List<Role> roles = (List<Role>) roleRepository.findAll();
         
        mav.addObject("allRoles", roles);
         
        return mav;    
    }  
     
    @GetMapping("/users/edit/{id}")
    public ModelAndView editUser(@PathVariable(name = "id") Long id) {
        Optional<User> user = service.findById(id);
        ModelAndView mav = new ModelAndView("user_form");
        mav.addObject("user", user);
         
        List<Role> roles = (List<Role>) roleRepository.findAll();
         
        mav.addObject("allRoles", roles);
         
        return mav;
    } 
    
//    @RequestMapping(path = { "/editt/{globalUserId}"})
//	public String editUserById(Model model, @PathVariable(value="") Optional<String> globalUserId) 
//							throws RecordNotFoundException 
//	{
//		
//		System.out.println("editUserById" + globalUserId);
//		if (globalUserId.isPresent()) {
//			User entity = userService.getUserById(globalUserId.get());
//			model.addAttribute("user", entity);
//		} else {
//			model.addAttribute("user", new User());
//		}
//		
//		
//		return "edituser";
//	}
    
    
    
    
    
    
    
}