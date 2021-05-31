package com.flhub.ideams.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.flhub.ideams.Repository.RoleRepository;
import com.flhub.ideams.Services.CountryService;
import com.flhub.ideams.Services.GenderService;
import com.flhub.ideams.Services.UserService;
import com.flhub.ideams.models.Country;
import com.flhub.ideams.models.Gender;
import com.flhub.ideams.models.Role;
import com.flhub.ideams.models.User;
import com.flhub.ideams.util.JwtUtil;


// @Controller
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:3001" })
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
    
    @GetMapping("/users")
    public Iterable<User> viewUserPage () {
    	return service.findAll();
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
    @PostMapping(path="/users")
    private User saveuser(@RequestBody User user) {

    return service.save(user);
    
        
    
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
    
    
@Autowired
private JwtUtil jwtUtil;
@Autowired
private AuthenticationManager authenticationManager;

@GetMapping("/")
public String welcome() {
    return "Welcome to javatechie !!";
}

@PostMapping("/authenticate")
public String generateToken(@RequestBody User user) throws Exception {
    try {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
    } catch (Exception ex) {
        throw new Exception("inavalid username/password");
    }
    return jwtUtil.generateToken(user.getUsername());
}
    
    
    
    
}