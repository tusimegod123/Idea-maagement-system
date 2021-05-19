package com.flhub.ideams.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flhub.ideams.Repository.CategoryRepository;
import com.flhub.ideams.models.Category;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

	public <S extends Category> S save(S entity) {
		return categoryRepository.save(entity);
	}

	public <S extends Category> Iterable<S> saveAll(Iterable<S> entities) {
		return categoryRepository.saveAll(entities);
	}

	public Optional<Category> findById(Integer id) {
		return categoryRepository.findById(id);
	}

	public boolean existsById(Integer id) {
		return categoryRepository.existsById(id);
	}

	public List<Category> findAll() {
		return (List<Category>) categoryRepository.findAll();
	}

	public Iterable<Category> findAllById(Iterable<Integer> ids) {
		return categoryRepository.findAllById(ids);
	}

	public long count() {
		return categoryRepository.count();
	}

	public void deleteById(Integer id) {
		categoryRepository.deleteById(id);
	}

	public void delete(Category entity) {
		categoryRepository.delete(entity);
	}

	public void deleteAll(Iterable<? extends Category> entities) {
		categoryRepository.deleteAll(entities);
	}

	public void deleteAll() {
		categoryRepository.deleteAll();
	}
	
	

}
