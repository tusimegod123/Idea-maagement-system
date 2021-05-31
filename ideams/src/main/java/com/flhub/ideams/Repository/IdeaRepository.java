package com.flhub.ideams.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


import com.flhub.ideams.models.Idea;


public interface IdeaRepository extends PagingAndSortingRepository<Idea, String> {
	
	List<Idea> findAll();
	@Query("SELECT i FROM Idea i WHERE CONCAT(i.ideaTitle,'',i.ideaDescription)  LIKE %?1%")
	public List<Idea> search(String keyword);

    Idea getOne(String ideaId);
  
	
  // public List<Idea> findIdeaByUserId(Integer user_id);
//
//	    List<Idea> findAllByOrderByIdDesc();
// @Query("SELECT u FROM Idea u WHERE u.ideaId = :ideaId")
//     public Idea findById(@Param("ideaId") Idea idea);
// Idea save(Optional<Idea> idea);


	// @Query("SELECT u FROM User u WHERE u.username = :username")
    // public User getUserByUsername(@Param("username") String username)


	//"SELECT u FROM User u WHERE CONCAT(u.first_name, ' ', u.last_name, ' ', u.middle_name, ' ', u.primaryEmail) LIKE %?1%"

}

