package com.flhub.ideams.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;


import com.flhub.ideams.Exceptions.RecordNotFoundException;
import com.flhub.ideams.Repository.CategoryRepository;
import com.flhub.ideams.Repository.IdeaRepository;
import com.flhub.ideams.Repository.UserRepository;

import com.flhub.ideams.models.Idea;



@Service
public class IdeaService implements Ideas {

	@Autowired
	IdeaRepository ideaRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CategoryService categoryService;

	public List<Idea> getAllIdeas() {

		List<Idea> result = (List<Idea>) ideaRepository.findAll();
		if (result.size() > 0) {
			return result;

		} else {
			return new ArrayList<Idea>();
		}

	}

	public List<Idea> findAll(String keyword) {
		if (keyword != null) {
			return ideaRepository.search(keyword);
		}
		return ideaRepository.findAll();
	}

	public Idea getIdeaById(String id) {
		return (Idea) ideaRepository.findById(id).get();
	}

	public Page<Idea> findAll(org.springframework.data.domain.Pageable pageable) {
		return ideaRepository.findAll(pageable);
	}

	public void delete(String idea_id) {
		ideaRepository.findById(idea_id);
	}

	public void deleteIdeaById(String idea_id) throws RecordNotFoundException {
		System.out.println("deleteIdeaById");

		Optional<Idea> idea = ideaRepository.findById(idea_id);

		if (idea.isPresent()) {
			ideaRepository.deleteById(idea_id);
		} else {
			throw new RecordNotFoundException("No idea record exist for given id");
		}
	}

	public Idea getEmployeeById(String idea_id) throws RecordNotFoundException {
		// System.out.println("getEmployeeById");
		Optional<Idea> idea = ideaRepository.findById(idea_id);

		if (idea.isPresent()) {
			return idea.get();
		} else {
			throw new RecordNotFoundException("No idea record exist for given id");
		}
	}

	public Idea createOrUpdateIdea(Idea entity) {
		System.out.println("createOrUpdateIdea");
		// Create new entry
		if (entity.getIdeaId() == null) {
			entity = ideaRepository.save(entity);

			return entity;
		} else {
			// update existing entry
			Optional<Idea> idea = ideaRepository.findById(entity.getIdeaId());

			if (idea.isPresent()) {
				Idea newEntity = idea.get();
				newEntity.setIdeaTitle(entity.getIdeaTitle());
				// newEntity.setFirstName(entity.getFirstName());
				// newEntity.setLastName(entity.getLastName());

				newEntity = ideaRepository.save(newEntity);

				return newEntity;
			} else {
				entity = ideaRepository.save(entity);

				return entity;
			}
		}
	}

	public List<Idea> search(String keyword) {
		return ideaRepository.search(keyword);
	}

	public Idea save(Idea idea) {
		// UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		// User user = userRepository.getUserByUsername(userDetails.getUsername());
		// idea.setUser_id(user.getId());
		// ideaRepository.save(idea);
		return ideaRepository.save(idea);
	}

	// public Idea saveOrUpdate(Idea idea, String ideaId) {
	// 	Idea currentIdea = ideaRepository.getIdeaById(ideaId);
	// 	return ideaRepository.save(currentIdea);
	// }

	@Override
	public Page<Idea> findPaginated(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return this.ideaRepository.findAll(pageable);

	}

	// public List<Idea> getIdeasByUser(Integer user_id){

	// List<Idea> ideas = new ArrayList<>();

	// ideaRepository.findIdeaByUserId(user_id)
	// .forEach(ideas ::add);

	// return ideas;
	// }

	public List<Idea> findAll() {
		return null;
	}

	public Idea saveOrUpdate(Idea idea, String ideaId) {
	//	Idea currentIdea = ideaRepository.findById(ideaId).get();


		return ideaRepository.save(idea);
	}

}
