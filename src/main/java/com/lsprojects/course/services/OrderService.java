package com.lsprojects.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsprojects.course.entities.Order;
import com.lsprojects.course.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public Order findByID(Long id) {
		Optional<Order> obj = orderRepository.findById(id);
		return obj.get();
	}

}
