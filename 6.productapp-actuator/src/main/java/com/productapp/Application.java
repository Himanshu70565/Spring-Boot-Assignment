package com.productapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.productapp.model.service.ProductService;
import com.productapp.web.entities.Product;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Application implements CommandLineRunner {

	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product1 = new Product("Tire", 500.0, 250.0, "Car Accessory", 2L);
		Product product2 = new Product("Window", 600.0, 350.0, "Body Accessory", 3L);
		Product product3 = new Product("Seats", 700.0, 450.0, "Interior Accessory", 4L);
		
	}

}
