package com.restful.webservices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.restful.webservices.exception.UserNotFoundException;
import com.restful.webservices.model.User;
import com.restful.webservices.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return userService.findAll();
	}

	@GetMapping("users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable long id) {
		User user = userService.findOne(id);
		if (user == null)
			throw new UserNotFoundException("id- " + id +" not found");

		EntityModel<User> model = EntityModel.of(user);
		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());

		model.add(linkToUsers.withRel("all-users"));
		return model;
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("users/{id}")
	public ResponseEntity<Object> updateUser(@Valid @RequestBody User user, @PathVariable long id) {

		User userForUpdate = userService.findOne(id);
		if (user == null)
			throw new UserNotFoundException("id- " + id +" not found");
		else {
			userForUpdate.setName(user.getName());
			userForUpdate.setBirthDate(user.getBirthDate());

			userService.updateUser(userForUpdate);

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("")
					.buildAndExpand(userForUpdate.getId()).toUri();
			return ResponseEntity.created(location).build();
		}

	}

	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable long id) {
		User user = userService.findOne(id);
		if (user == null)
			throw new UserNotFoundException("id- " + id +" not found");
		else
			userService.deleteById(id);

	}
	
}
