package com.web.aulaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.aulaproject.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
  
}
