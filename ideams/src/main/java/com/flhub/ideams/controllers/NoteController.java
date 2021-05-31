package com.flhub.ideams.controllers;



import com.flhub.ideams.Exceptions.RecordNotFoundException;
import com.flhub.ideams.Repository.IdeaRepository;
import com.flhub.ideams.Repository.UserRepository;
import com.flhub.ideams.Services.CategoryService;
import com.flhub.ideams.Services.IdeaService;
import com.flhub.ideams.Services.NoteService;

import com.flhub.ideams.models.Idea;
import com.flhub.ideams.models.Note;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoteController {

   @Autowired
   IdeaService ideaService;

   @Autowired
   UserRepository userRepository;

   @Autowired
   CategoryService categoryService;

   @Autowired
   NoteService noteService;

   @Autowired
   IdeaRepository ideaRepository;

   @GetMapping(value = "/notes")
   public String getNotes() {
      return "notes";
   }

   @PostMapping("/addnote")
   private String saveNote(Note note, Idea idea) {
      // Idea idea = ideaRepository.findById(ideaService.getIdeaById(idea));
      // Idea entity = ideaService.getIdeaById(ideaId.get());
      // note.setIdeaId(idea.getIdeaId());
      noteService.save(note);
      // System.out.println(idea.getIdeaId());
      return "notes";

   }

   @PutMapping
   public String editNote() {
      return "notes";
   }

   @RequestMapping(path = { "/comment/{ideaId}" })
   public String editIdeaById(Model model, @PathVariable(value = "ideaId") String ideaId)
         throws RecordNotFoundException {

      System.out.println("editIdeaById" + ideaId);
      if (!ideaId.isBlank()) {
         // List<Category> category = categoryService.findAll();
         Idea entity = ideaService.getIdeaById(ideaId);
         Long note = noteService.count();
         model.addAttribute("idea", entity);
         model.addAttribute("totalcomments", note);
         // model.addAttribute("ideacategory", category);
         model.addAttribute("note", new Note());
      } else {
         // model.addAttribute("totalcomments", note);
         model.addAttribute("idea", new Idea());
         model.addAttribute("ideacategory", new Idea());

      }

      return "notes";
   }

}
