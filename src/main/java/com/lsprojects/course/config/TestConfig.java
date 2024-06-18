package com.lsprojects.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lsprojects.course.entities.Category;
import com.lsprojects.course.entities.Order;
import com.lsprojects.course.entities.User;
import com.lsprojects.course.entities.enums.OrderStatus;
import com.lsprojects.course.repositories.CategoryRepository;
import com.lsprojects.course.repositories.OrderRepository;
import com.lsprojects.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Jon Doe", "jondoe@example.com", "999999999", "risos");
		User u2 = new User(null, "Little Doe", "littleDoe@example.com", "988887777", "sisos");
		User u3 = new User(null, "Big Joe", "bj@example.com", "999990101", "migos");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.DELIVERED, u3);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAIMENT, u1);

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
	}
}
