package com.web.aulaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.aulaproject.entities.OrderItem;
import com.web.aulaproject.entities.pk.OrderItemPk;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
}
