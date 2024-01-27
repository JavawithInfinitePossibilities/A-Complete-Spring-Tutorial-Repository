package com.tutorials.sid.spring.services.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.tutorials.sid.spring.model.entity.User;
import com.tutorials.sid.spring.repository.dao.UserRepository;

/**
 * Look at H2 Console : http://localhost:8080/h2-console
 * 
 * @author Lenovo
 *
 */
@Component
public class UserCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);

	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... args) throws Exception {

		repository.save(new User("Ranga", "Admin"));
		repository.save(new User("Ravi", "User"));
		repository.save(new User("Satish", "Admin"));
		repository.save(new User("Raghu", "User"));

		for (User user : repository.findAll()) {
			log.info("==> User details : " + user.toString());
		}

		log.info("Admin users are.....");
		log.info("____________________");
		for (User user : repository.findByRole("Admin")) {
			log.info("Admin User details : " + user.toString());
		}

	}

}