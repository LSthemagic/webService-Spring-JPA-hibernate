package com.lsprojects.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.lsprojects.course.entities.Product;
import com.lsprojects.course.repositories.ProductRepository;
import com.lsprojects.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findByID(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
	public Product insert(Product obj) {
		return repository.save(obj);
	}

	public Product update(Long id, Product obj) {
		try {
			Product reference = repository.getReferenceById(id);
			updateData(reference, obj);
			return repository.save(reference);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Product reference, Product obj) {
		reference.setDescription(obj.getDescription());
		reference.setImgUrl(obj.getImgUrl());
		reference.setName(obj.getName());
		reference.setPrice(obj.getPrice());
	}

	public void delete(Long id) {
		try {
			if(!repository.existsById(id)) {
				throw new ResourceNotFoundException(id);
			}
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException(e.getLocalizedMessage());
		}
	}

}
