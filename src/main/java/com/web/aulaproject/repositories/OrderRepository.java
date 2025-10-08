package com.web.aulaproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.web.aulaproject.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    @Query("SELECT o FROM Order o JOIN FETCH o.client")
    List<Order> findAllWithClient();
  
}
