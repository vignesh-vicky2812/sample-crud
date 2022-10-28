package com.restful.webservices.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restful.webservices.model.User;
import com.restful.webservices.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public List<User> findAll() {
		return userRepo.findAll();
	}

	public User findOne(long id) {

		return userRepo.findById(id);
	}

	public User save(@Valid User user) {
		return userRepo.save(user);
	}

	public void deleteById(long id) {
		userRepo.deleteById(id);

	}

	public void updateUser(User tempUser) {
		userRepo.save(tempUser);
	}

}
