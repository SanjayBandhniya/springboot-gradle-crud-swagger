package org.example.service;

import java.util.List;
import java.util.Optional;

import org.example.domain.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	public User save(User newUser) {
		return userRepository.save(newUser);
	}

	public void deleteById(Long id) {
		userRepository.delete(findById(id).get());

	}

}
