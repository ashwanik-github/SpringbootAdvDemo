package com.springboot.adv.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLine implements CommandLineRunner {

	// creating the UserRepository method for feed at the startup
	@Autowired
	private UserRepository repository;

	// adding the Logger for the class hereby
	private static final Logger log = LoggerFactory.getLogger(UserCommandLine.class);

	@Override
	public void run(String... args) throws Exception {
		repository.save(new User("Ashwani", "Admin"));
		repository.save(new User("Aman", "User"));
		repository.save(new User("Revathi", "User"));
		repository.save(new User("Sooraj", "Developer"));
		repository.save(new User("Khalifa", "Developer"));

		// iterate the List by checking the Log
		for (User user : repository.findAll()) {
			log.info(user.toString());
		}
		// adding another method for the search of the Admin User hereby
		log.info("-----------------Admin Users are below-------------------");
		for (User user : repository.findByRole("User")) {
			log.info(user.toString());
		}
	}

}
