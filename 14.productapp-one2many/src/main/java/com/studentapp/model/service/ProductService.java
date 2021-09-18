package com.studentapp.model.service;

import java.util.*;

import com.studentapp.web.entities.Product;

public interface ProductService {
	public List<Product> getAllProducts();

	public Product addProduct(Product product);

	public Product deleteProduct(int product);

	public Product updateProduct(int id, Product product);

	public Product getProductById(Integer id);
}
