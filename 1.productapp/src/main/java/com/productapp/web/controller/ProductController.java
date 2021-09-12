package com.productapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.service.ProductService;
import com.productapp.web.entities.Product;

@RestController
public class ProductController {

	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/product")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable(name = "id") long id) {
		return productService.getProductById(id);
	}

	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@DeleteMapping("/product/{id}")
	public Product deleteProduct(@PathVariable(name = "id") long id) {
		return productService.deleteProduct(id);
	}

	@PutMapping("/product/{id}")
	public Product updateProduct(@PathVariable(name = "id") long id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}
}
