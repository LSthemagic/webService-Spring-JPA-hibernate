package com.lsprojects.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsprojects.course.entities.Category;
import com.lsprojects.course.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository orderRepository;

	public List<Category> findAll() {
		return orderRepository.findAll();
	}

	public Category findByID(Long id) {
		Optional<Category> obj = orderRepository.findById(id);
		return obj.get();
	}

}
