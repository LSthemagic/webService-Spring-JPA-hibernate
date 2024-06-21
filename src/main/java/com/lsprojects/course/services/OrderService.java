package com.lsprojects.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.lsprojects.course.entities.Order;
import com.lsprojects.course.repositories.OrderRepository;
import com.lsprojects.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;

	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findByID(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}

	public Order insert(Order obj) {
		return repository.save(obj);
	}

	public Order update(Long id, Order obj) {
		try {
			Order reference = repository.getReferenceById(id);
			updateData(reference, obj);
			return repository.save(reference);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Order reference, Order obj) {
		reference.setOrderStatus(obj.getOrderStatus());
	}

	public void delete(Long id) {
		try {
			if (!repository.existsById(id)) {
				throw new ResourceNotFoundException(id);
			}
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException(e.getLocalizedMessage());
		}
	}

}
