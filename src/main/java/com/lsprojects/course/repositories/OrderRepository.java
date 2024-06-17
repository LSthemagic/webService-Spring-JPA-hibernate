package com.lsprojects.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lsprojects.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
