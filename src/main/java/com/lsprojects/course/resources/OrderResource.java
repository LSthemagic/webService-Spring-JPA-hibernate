package com.lsprojects.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lsprojects.course.entities.Order;
import com.lsprojects.course.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	@Autowired
	private OrderService orderService;

	@GetMapping("/listOrders")
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = orderService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = orderService.findByIDOrder(id);
		return ResponseEntity.ok().body(obj);
	}

}
