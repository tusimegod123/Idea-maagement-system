package com.flhub.ideams.Repository;

import org.springframework.data.repository.CrudRepository;

import com.flhub.ideams.models.Country;



public interface CountryRepository extends CrudRepository<Country, Integer>  {

}
