package com.restful.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restful.webservices.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findById(long id);

}
