package com.web.aulaproject.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.web.aulaproject.entities.User;
import com.web.aulaproject.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;


	@Override
	public void run(String... args) throws Exception {
		User p1 = new User(null,"Paul","paullol@gmail.com", "839999499","martin10");
		User p2 = new User(null,"Judith","judithgrimes@gmail.com", "8399994888","rickgrimes");
		
		userRepository.saveAll(Arrays.asList(p1,p2));
	}
	
}
