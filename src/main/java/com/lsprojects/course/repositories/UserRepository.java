package com.lsprojects.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lsprojects.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
