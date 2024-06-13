package com.lsprojects.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lsprojects.course.entities.User;
import com.lsprojects.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Jon Doe", "jondoe@example.com", "999999999", "risos");
		User u2 = new User(null, "Little Doe", "littleDoe@example.com", "988887777", "sisos");
		User u3 = new User(null, "Big Joe", "bj@example.com", "999990101", "migos");

		userRepository.saveAll(Arrays.asList(u1, u2, u3));
	}
}
