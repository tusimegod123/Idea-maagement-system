package com.flhub.ideams.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flhub.ideams.Repository.RoleRepository;
import com.flhub.ideams.models.Role;




@Service
public class RoleService {
	
	@Autowired
	RoleRepository roleRepository;

	public <S extends Role> S save(S entity) {
		return roleRepository.save(entity);
	}

	public <S extends Role> Iterable<S> saveAll(Iterable<S> entities) {
		return roleRepository.saveAll(entities);
	}

	public Optional<Role> findById(Integer id) {
		return roleRepository.findById(id);
	}

	public boolean existsById(Integer id) {
		return roleRepository.existsById(id);
	}

	public Iterable<Role> findAll() {
		return roleRepository.findAll();
	}

	public Iterable<Role> findAllById(Iterable<Integer> ids) {
		return roleRepository.findAllById(ids);
	}

	public long count() {
		return roleRepository.count();
	}

	public void deleteById(Integer id) {
		roleRepository.deleteById(id);
	}

	public void delete(Role entity) {
		roleRepository.delete(entity);
	}

	public void deleteAll(Iterable<? extends Role> entities) {
		roleRepository.deleteAll(entities);
	}

	public void deleteAll() {
		roleRepository.deleteAll();
	}
	
	

}
