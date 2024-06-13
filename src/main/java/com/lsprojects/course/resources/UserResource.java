package com.lsprojects.course.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lsprojects.course.entities.User;
import com.lsprojects.course.repositories.UserRepository;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
//	private UserRepository userRepository;

	@GetMapping("/listUsers")
	public ResponseEntity<List<User>> findAll() {
		List<User> list = new ArrayList<User>();
		User u = new User(1L, "Jon Doe", "jondoe@example.com", "999999999", "kakaka");
		User u1 = new User(2L, "fulano", "fulano@example.com", "9999999990", "hahaha");
		list.add(u);
		list.add(u1);
		return ResponseEntity.ok().body(list);
	}
}
