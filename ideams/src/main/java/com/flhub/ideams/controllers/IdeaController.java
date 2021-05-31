package com.flhub.ideams.controllers;

import com.flhub.ideams.Exceptions.RecordNotFoundException;
import com.flhub.ideams.Repository.UserRepository;
import com.flhub.ideams.Services.CategoryService;
import com.flhub.ideams.Services.IdeaService;
//import com.flhub.ideams.Services.UserService;
import com.flhub.ideams.models.Category;
import com.flhub.ideams.models.Idea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.multipart.MultipartFile;

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

	// @Autowired
	// private UserService service;

	// creating a get mapping that retrieves all the ideas detail from the database
	@GetMapping("/idea")
	private List<Idea> getAllIdeas() {

		return ideaService.getAllIdeas();
	}

	@PostMapping(path = "/idea")
	public Idea createIdea(@RequestBody Idea idea) {
		return ideaService.save(idea);
	}

	@GetMapping("/idea/{ideaId}")
	private Idea getIdeas(@PathVariable("ideaId") String ideaId) {
		return ideaService.getIdeaById(ideaId);
	}

	@DeleteMapping(path = "/idea/{ideaId}")
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

	@PatchMapping(path = { "/idea/{ideaId}" })
	public Idea editIdeaById(@RequestBody Idea idea, @PathVariable("ideaId") String ideaId)
			throws RecordNotFoundException {
		return ideaService.saveOrUpdate(idea, ideaId);
	}

	@GetMapping("/home")
	public String home(Model model) {

		List<Category> category = categoryService.findAll();

		model.addAttribute("idea", new Idea());

		model.addAttribute("ideacategory", category);

		return "home";
	}

	@GetMapping("/search")
	public String search(@Param("keyword") String keyword, Model model) {
		System.out.println("keyword" + keyword);

		List<Idea> searchResult = ideaService.search(keyword);
		model.addAttribute("keyword", keyword);
		model.addAttribute("ideaTitle", "search resluts fror '" + keyword + "'");
		model.addAttribute("searchResult", searchResult);

		return "searchresult";

	}

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
