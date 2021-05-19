package com.flhub.ideams.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.flhub.ideams.models.Category;


public interface CategoryRepository extends CrudRepository<Category, Integer> {
	
	  @Query("SELECT u FROM Category u WHERE u.category_id = :category_id")
	public List<Category> findIdeaByCategoryId(Integer category_id);
	

}
