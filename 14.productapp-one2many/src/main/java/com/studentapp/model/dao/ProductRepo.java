package com.studentapp.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentapp.web.entities.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

}
