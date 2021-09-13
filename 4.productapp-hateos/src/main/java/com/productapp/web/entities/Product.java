package com.productapp.web.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.hateoas.RepresentationModel;
import org.yaml.snakeyaml.representer.Representer;

@Entity
@Table(name = "product_table")
public class Product extends RepresentationModel<Product>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	@Size(min = 1,message = "Enter productName with minLength 1")
	private String productName;
	private Double productPrice;
	private Double productDiscount;
	private String productCategory;
	private Long productQuantity;

	public Product() {
	}

	public Product(String productName, Double productPrice, Double productDiscount, String productCategory,
			Long productQuantity) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}

	public Product(Long productId, String productName, Double productPrice, Double productDiscount,
			String productCategory, Long productQuantity) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Double getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(Double productDiscount) {
		this.productDiscount = productDiscount;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public Long getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Long productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productId=");
		builder.append(productId);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", productPrice=");
		builder.append(productPrice);
		builder.append(", productDiscount=");
		builder.append(productDiscount);
		builder.append(", productCategory=");
		builder.append(productCategory);
		builder.append(", productQuantity=");
		builder.append(productQuantity);
		builder.append("]");
		return builder.toString();
	}

}
