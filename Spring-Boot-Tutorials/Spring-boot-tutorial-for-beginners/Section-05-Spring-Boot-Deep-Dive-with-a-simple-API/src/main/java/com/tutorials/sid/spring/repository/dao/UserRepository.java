package com.tutorials.sid.spring.repository.dao;

import org.springframework.data.repository.CrudRepository;

import com.tutorials.sid.spring.model.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User[] findByRole(String string);
}