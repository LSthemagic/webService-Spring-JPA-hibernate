package com.lsprojects.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lsprojects.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}