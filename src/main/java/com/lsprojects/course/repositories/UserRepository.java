package com.lsprojects.course.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lsprojects.course.entities.User;

@Repository
@Qualifier("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	
}
