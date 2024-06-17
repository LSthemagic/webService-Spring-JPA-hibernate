package com.lsprojects.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lsprojects.course.entities.Order;
import com.lsprojects.course.entities.User;
import com.lsprojects.course.repositories.OrderRepository;
import com.lsprojects.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Jon Doe", "jondoe@example.com", "999999999", "risos");
		User u2 = new User(null, "Little Doe", "littleDoe@example.com", "988887777", "sisos");
		User u3 = new User(null, "Big Joe", "bj@example.com", "999990101", "migos");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u3);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
