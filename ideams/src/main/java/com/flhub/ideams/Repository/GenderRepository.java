package com.flhub.ideams.Repository;

import org.springframework.data.repository.CrudRepository;

import com.flhub.ideams.models.Gender;



public interface GenderRepository extends CrudRepository <Gender, Integer> {

}
