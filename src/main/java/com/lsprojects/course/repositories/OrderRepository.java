package com.lsprojects.course.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lsprojects.course.entities.Order;

@Repository
@Qualifier("orderRepository")
public interface OrderRepository extends JpaRepository<Order, Long> {

}
