package com.productapp.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(name = "id") long id) {
		return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(id));
	}

	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(product));
	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable(name = "id") long id) {
		productService.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("product with id :"+id+" deleted successfully");
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(name = "id") long id,@RequestBody Product product) {
		return  ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id, product));
	}
}
