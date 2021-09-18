package com.studentapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentapp.model.dao.ReviewRepo;
import com.studentapp.model.service.ProductService;
import com.studentapp.model.service.ReviewService;
import com.studentapp.web.entities.Product;
import com.studentapp.web.entities.Review;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private ProductService productService;
	private ReviewService reviewService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Autowired
	public void setReviewService(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Review r1 = new Review("Good product", 4, "Himanshu");
		Review r2 = new Review("Worst product", 1, "Kamla");
		Review r3 = new Review("Poor Quality product", 2, "Rahul");
		Review r4 = new Review("Good product and quality", 5, "Sahil");

		Product product1 = new Product("Tire", 500.0, 250.0, "Car Accessory", 2L);
		Product product2 = new Product("Window", 600.0, 350.0, "Body Accessory", 3L);

		// Setting product reviews
		product1.getReviews().add(r1);
		product1.getReviews().add(r2);
		product1.getReviews().add(r3);
		product2.getReviews().add(r4);

		// Setting review product
		r1.setProduct(product1);
		r2.setProduct(product1);
		r3.setProduct(product1);
		r4.setProduct(product2);

		productService.addProduct(product1);
		productService.addProduct(product2);
		
		System.out.println(reviewService);
		reviewService.addReview(r1);
//		reviewService.addReview(r2);
//		reviewService.addReview(r3);
//		reviewService.addReview(r4);
		
		
	}

}
