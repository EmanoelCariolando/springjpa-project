package com.web.aulaproject.config;

import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.web.aulaproject.entities.Category;
import com.web.aulaproject.entities.Order;
import com.web.aulaproject.entities.User;
import com.web.aulaproject.entities.enums.EnumOrder;
import com.web.aulaproject.repositories.CategoryRepository;
import com.web.aulaproject.repositories.OrderRepository;
import com.web.aulaproject.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;


	@Override
	public void run(String... args) throws Exception {
		
		Category c1 = new Category(null,"Eletronic");
		Category c2 = new Category(null,"Domestics");
		
		
		User p1 = new User(null,"Paul","paullol@gmail.com", "839999499","martin10");
		User p2 = new User(null,"Judith","judithgrimes@gmail.com", "8399994888","rickgrimes");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),EnumOrder.WAITING_PAYMENT, p1);
		Order o2 = new Order(null, Instant.parse("2012-06-20T19:53:07Z"), EnumOrder.PAID, p2);
		Order o3 = new Order(null, Instant.parse("2010-06-20T19:53:07Z"),EnumOrder.WAITING_PAYMENT , p1);
		
		userRepository.saveAll(Arrays.asList(p1,p2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		categoryRepository.saveAll(Arrays.asList(c1,c2));
	}
	
	
}
