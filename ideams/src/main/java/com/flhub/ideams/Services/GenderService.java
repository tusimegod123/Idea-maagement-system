package com.flhub.ideams.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flhub.ideams.Repository.GenderRepository;
import com.flhub.ideams.models.Gender;



@Service
public class GenderService {
	
	@Autowired
	GenderRepository genderRepository;

	public <S extends Gender> S save(S entity) {
		return genderRepository.save(entity);
	}

	public <S extends Gender> Iterable<S> saveAll(Iterable<S> entities) {
		return genderRepository.saveAll(entities);
	}

	public Optional<Gender> findById(Integer id) {
		return genderRepository.findById(id);
	}

	public boolean existsById(Integer id) {
		return genderRepository.existsById(id);
	}

	public List<Gender> findAll() {
		return (List<Gender>) genderRepository.findAll();
	}
	
	
//	public List<Gender> getAllIGender() {
//
//		List<Gender> result = (List<Gender>) genderRepository.findAll();
//		if(result.size() > 0) {
//			return result;
//			
//		}else {
//			return new ArrayList<Gender>();
//		}
//
//}
	

	public Iterable<Gender> findAllById(Iterable<Integer> ids) {
		return genderRepository.findAllById(ids);
	}

	public long count() {
		return genderRepository.count();
	}

	public void deleteById(Integer id) {
		genderRepository.deleteById(id);
	}

	public void delete(Gender entity) {
		genderRepository.delete(entity);
	}

	public void deleteAll(Iterable<? extends Gender> entities) {
		genderRepository.deleteAll(entities);
	}

	public void deleteAll() {
		genderRepository.deleteAll();
	}

	
}
