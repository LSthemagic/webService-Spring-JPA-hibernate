package com.lsprojects.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lsprojects.course.entities.User;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping("/oneUser")
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Jon Doe", "jondoe@example.com", "999999999", "kakaka");
		return ResponseEntity.ok().body(u);
	}
}
