package com.flhub.ideams.controllers;

import com.flhub.ideams.Exceptions.RecordNotFoundException;
import com.flhub.ideams.Repository.UserRepository;
import com.flhub.ideams.Services.CategoryService;
import com.flhub.ideams.Services.IdeaService;
import com.flhub.ideams.Services.UserService;
import com.flhub.ideams.models.Category;
import com.flhub.ideams.models.Idea;
import com.flhub.ideams.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = { "http://localhost:3001" })
// @]RestController
// @RequestMapping("/api")
// @RequestMapping
public class IdeaController {

	@Autowired
	IdeaService ideaService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CategoryService categoryService;

	@Autowired
    private UserService service;

	// creating a get mapping that retrieves all the ideas detail from the database
	@GetMapping("/ideas")
	private List<Idea> getAllIdeas() {

		return ideaService.getAllIdeas();
	}

	@PostMapping(path = "/ideas")
	public Idea createIdea(@RequestBody Idea idea)
		{
			return ideaService.save(idea);
		}

		// @GetMapping("/users")
		// public Iterable<User> viewUserPage () {
		// 	return service.findAll();
		// }
	

	// @GetMapping("api/messages/hello")
	// public String hello(){
	// return "This mesage is from the back end";
	// }

	// creating a get mapping that retrieves the detail of a specific user
	@GetMapping("/idea/{ideaId}")
	private Idea getIdeas(@PathVariable("ideaId") String ideaId) {
		return ideaService.getIdeaById(ideaId);
	}

	@RequestMapping(path = "/delete/{ideaId}")
	public String deleteIdea(@PathVariable(value = "ideaId") String ideaId) {
		System.out.println(ideaId);
		try {
			ideaService.deleteIdeaById(ideaId);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/seeideas";
	}

	@RequestMapping(path = { "/edit/{ideaId}" })
	public String editIdeaById(Model model, @PathVariable(value = "ideaId") String ideaId)
			throws RecordNotFoundException {

		System.out.println("editIdeaById" + ideaId);
		if (!ideaId.isBlank()) {
			List<Category> category = categoryService.findAll();
			Idea entity = ideaService.getIdeaById(ideaId);
			model.addAttribute("idea", entity);
			model.addAttribute("ideacategory", category);
		} else {
			model.addAttribute("idea", new Idea());
			model.addAttribute("ideacategory", new Idea());

		}

		return "editIdea";
	}

	// creating post mapping that post the user details in the database at /ideas
	// route(in the form)
	// @PostMapping(value = "/ideas")
	// private String saveIdea(@ModelAttribute Idea idea, @RequestParam("content") MultipartFile file,
	// 		Authentication authentication) throws IllegalStateException, IOException {
	// 	String filePath = "C:\\Users\\a241904\\Documents\\workspace\\demoApp\\src\\main\\resources\\static\\assets\\uploads\\";
	// 	file.transferTo(new File(filePath + "myFile.jpg"));
	// 	// User user = new User();

	// 	ideaService.save(idea, authentication);

	// 	// System.out.println(user);
	// 	return "redirect:/seeideas";
	// }

	@GetMapping("/home")
	public String home(Model model) {

		List<Category> category = categoryService.findAll();

		model.addAttribute("idea", new Idea());

		model.addAttribute("ideacategory", category);

		return "home";
	}

	// @PostMapping("/createIdea")
	// public String saveOrUpdate(Idea idea, Authentication authentication, Model model) {
	// 	System.out.println("saveOrUpdate ");

	// 	ideaService.saveOrUpdate(idea);

	// 	return "redirect:/seeideas";
	// }

	@GetMapping("/search")
	public String search(@Param("keyword") String keyword, Model model) {
		System.out.println("keyword" + keyword);

		List<Idea> searchResult = ideaService.search(keyword);
		model.addAttribute("keyword", keyword);
		model.addAttribute("ideaTitle", "search resluts fror '" + keyword + "'");
		model.addAttribute("searchResult", searchResult);

		return "searchresult";

	}

	// @GetMapping(value = "/seeideas")
	// public String getAlldeas(Model model) {
	// // List<Idea> idea = ideaService.getAllIdeas();
	// // model.addAttribute("ideas", idea);
	// return findPaginated(1, model);
	// // 1 is the default pageNo
	// // return "ideas";
	// }

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
		int pageSize = 1;

		Page<Idea> page = ideaService.findPaginated(pageNo, pageSize);
		List<Idea> idea = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		// model.addAttribute("listIdeas", listIdeas);
		model.addAttribute("ideas", idea);
		return "ideas";
	}
}
