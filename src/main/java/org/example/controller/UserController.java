package org.example.controller;

import java.util.List;

import org.example.config.UserNotFoundException;
import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(path = "/user")
	public List<User> list() {
		return userService.findAll();
	}

	@GetMapping("/user/{id}")
	User getUser(@PathVariable Long id) {
		User user = userService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
		return user;
	}

	@PostMapping(path = "/user")
	public User save(@RequestBody User newUser) {
		return userService.save(newUser);
	}

	@PutMapping("/user/{id}")
	User replaceEmployee(@RequestBody User newUser, @PathVariable Long id) {

		User user = userService.findById(id).orElseThrow(() -> new UserNotFoundException(id));

		user.setFirstName(newUser.getFirstName());
		user.setLastName(newUser.getLastName());
		return user;

	}

	@DeleteMapping("/user/{id}")
	void deleteEmployee(@PathVariable Long id) {
		userService.deleteById(id);
	}

}