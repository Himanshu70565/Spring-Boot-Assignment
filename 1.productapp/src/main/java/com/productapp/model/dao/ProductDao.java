package com.productapp.model.dao;

import java.util.List;

import com.productapp.web.entities.Product;


public interface ProductDao {
	public List<Product> getAllProducts();

	public Product getProductById(long id);

	public Product addProduct(Product product);

	public Product deleteProduct(long product);

	public Product updateProduct(long id, Product product);

}
