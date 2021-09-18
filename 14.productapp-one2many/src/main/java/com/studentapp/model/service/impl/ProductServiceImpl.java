package com.studentapp.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.studentapp.model.dao.ProductRepo;
import com.studentapp.model.service.ProductService;
import com.studentapp.web.entities.Product;
import com.studentapp.web.exceptions.ResourceNotFoundException;

@Service
@Primary
public class ProductServiceImpl implements ProductService {

	private ProductRepo productRepo;

	@Autowired
	public void setProductRepo(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		return productRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("product with id  ; " + id + " not founded"));
	}

	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Product deleteProduct(int id) {
		Product productToBeDeleted = getProductById(id);
		productRepo.delete(productToBeDeleted);
		return productToBeDeleted;
	}

	@Override
	public Product updateProduct(int id, Product product) {
		Product productToBeUpdated = getProductById(id);
		productToBeUpdated.setProductPrice(product.getProductPrice());
		productRepo.save(productToBeUpdated);
		return productToBeUpdated;
	}

}
