package com.studentapp.web.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reviewId;
	private String review;
	private int rating;
	private String reviewerName;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_fk")
	@JsonBackReference
	private Product product;

	public Review() {
	}

	public Review(String review, int rating, String reviewerName) {
		this.review = review;
		this.rating = rating;
		this.reviewerName = reviewerName;
	}

	public Review(String review, int rating, String reviewerName, Product product) {
		this.review = review;
		this.rating = rating;
		this.reviewerName = reviewerName;
		this.product = product;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReviewerName() {
		return reviewerName;
	}

	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Review [reviewId=");
		builder.append(reviewId);
		builder.append(", review=");
		builder.append(review);
		builder.append(", rating=");
		builder.append(rating);
		builder.append(", reviewerName=");
		builder.append(reviewerName);
		builder.append("]");
		return builder.toString();
	}

	
	
}
