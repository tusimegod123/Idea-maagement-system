package com.flhub.ideams.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flhub.ideams.Repository.CountryRepository;
import com.flhub.ideams.models.Country;





@Service
public class CountryService {
	
	@Autowired
	CountryRepository countryRepository;
	
	public <S extends Country> S save(S entity) {
		return countryRepository.save(entity);
	}

	public <S extends Country> Iterable<S> saveAll(Iterable<S> entities) {
		return countryRepository.saveAll(entities);
	}

	public List<Country> findAll() {
		return (List<Country>) countryRepository.findAll();
	}
	
	// public Iterable<Country> findAllById(Country country) {
	// 	return countryRepository.findById(country);
	// }

	public void deleteById(Integer id) {
		countryRepository.deleteById(id);
	}

	public void delete(Country entity) {
		countryRepository.delete(entity);
	}

	public void deleteAll(Iterable<? extends Country> entities) {
		countryRepository.deleteAll(entities);
	}

	public Optional<Country> findById(Integer country) {
		return countryRepository.findById(country);
	}



}
