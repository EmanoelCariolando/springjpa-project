package com.web.aulaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.aulaproject.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
