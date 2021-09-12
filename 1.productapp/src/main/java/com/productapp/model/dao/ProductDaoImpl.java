package com.productapp.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.productapp.web.entities.Product;
import com.productapp.web.exceptions.ProductNotFoundException;

@Repository
@Primary
public class ProductDaoImpl implements ProductDao {

	private EntityManager entityManager;

	@Autowired
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Product> getAllProducts() {
		return entityManager.createQuery("select p from Product p", Product.class).getResultList();
	}

	@Override
	public Product getProductById(long id) {
		Product product = entityManager.find(Product.class, id);
		if(product==null) {
			throw new ProductNotFoundException("product with id : "+id+" not found");
		}
		return product;
	}

	@Override
	public Product addProduct(Product product) {
		entityManager.persist(product);
		return product;
	}

	@Override
	public Product deleteProduct(long id) {
		Product productToBeDeleted = getProductById(id);
		entityManager.remove(productToBeDeleted);
		return productToBeDeleted;
	}

	@Override
	public Product updateProduct(long id, Product product) {
		Product productToBeUpdated = getProductById(id);
		productToBeUpdated.setProductPrice(product.getProductPrice());
		return productToBeUpdated;
	}

}
