package com.flhub.ideams.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flhub.ideams.Repository.UserRepository;
import com.flhub.ideams.models.User;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User getUserByUsername(String username) {
		return userRepository.getUserByUsername(username);
	}

	// public <S extends User> S save(S entity) {
	// 	return userRepository.save(entity);
	// }

	public User save(User user) {
		return userRepository.save(user);
	}

	public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
		return userRepository.saveAll(entities);
	}

	
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	public boolean existsById(Long id) {
		return userRepository.existsById(id);
	}

	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	public Iterable<User> findAllById(Iterable<Long> ids) {
		return userRepository.findAllById(ids);
	}

	public long count() {
		return userRepository.count();
	}

	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	public void delete(User entity) {
		userRepository.delete(entity);
	}

	public void deleteAll(Iterable<? extends User> entities) {
		userRepository.deleteAll(entities);
	}

	public void deleteAll() {
		userRepository.deleteAll();
	}

	
}
