package com.web.aulaproject.config;

import java.time.Instant;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.web.aulaproject.entities.Category;
import com.web.aulaproject.entities.Order;
import com.web.aulaproject.entities.OrderItem;
import com.web.aulaproject.entities.Product;
import com.web.aulaproject.entities.User;
import com.web.aulaproject.entities.enums.EnumOrder;
import com.web.aulaproject.repositories.CategoryRepository;
import com.web.aulaproject.repositories.OrderItemRepository;
import com.web.aulaproject.repositories.OrderRepository;
import com.web.aulaproject.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository product;
	
	@Autowired
	private OrderItemRepository orderItem;


	@Override
	public void run(String... args) throws Exception {
		
		
		Product m1 = new Product(null,"CG 160","Year:2003 Color:BLUE" , 20.000 ,"https://image.webmotors.com.br/_fotos/anunciousados/gigante/2025/202507/20250723/honda-cg-160-titan-s-WMIMAGEM13033079161.jpg");
		Product m2 = new Product(null,"XRE 300","Year:2018 Color:BLACK" , 30.000 ,"https://s2-autoesporte.glbimg.com/rXpS9Gp2ZoWlT6QE4oZd4Zzp3ik=/0x0:1920x1554/1008x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_59edd422c0c84a879bd37670ae4f538a/internal_photos/bs/2017/r/F/DHOqlARLu9E5uHgpuMcw/xre-300-std-preta-3-4-fd.jpg");
		
		Category c1 = new Category(null,"Street");
		Category c2 = new Category(null,"Nacked");
		Category c3 = new Category(null,"Trail");
		
		
		User p1 = new User(null,"Paul","paullol@gmail.com", "839999499","martin10");
		User p2 = new User(null,"Judith","judithgrimes@gmail.com", "8399994888","rickgrimes");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),EnumOrder.WAITING_PAYMENT, p1);
		Order o2 = new Order(null, Instant.parse("2012-06-20T19:53:07Z"), EnumOrder.PAID, p2);
		Order o3 = new Order(null, Instant.parse("2010-06-20T19:53:07Z"),EnumOrder.WAITING_PAYMENT , p1);
		
		
		
		m1.getCategories().add(c1);
		m2.getCategories().add(c3);
	
		
		userRepository.saveAll(Arrays.asList(p1,p2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
		product.saveAll(Arrays.asList(m1,m2));
		
		OrderItem oi1 = new OrderItem(o1,m1,2,m1.getPrice());
		OrderItem oi2 = new OrderItem(o1,m2,1,m2.getPrice());
		OrderItem oi3 = new OrderItem(o2,m1,2,m1.getPrice());
		OrderItem oi4 = new OrderItem(o3,m2,1,m2.getPrice());
		
		orderItem.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
	   
	}
	
	
}
