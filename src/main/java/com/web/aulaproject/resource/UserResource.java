package com.web.aulaproject.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.aulaproject.entities.User;

@RestController
@RequestMapping("/users")
public class UserResource {

	@com.web.aulaproject.resource.RequestMapping
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Manel", "maneldocapa@gmail.com", "839999999", "*********");
		return ResponseEntity.ok().body(u);
	}
}
