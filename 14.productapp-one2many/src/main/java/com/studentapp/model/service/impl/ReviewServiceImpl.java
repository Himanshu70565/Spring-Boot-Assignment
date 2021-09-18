package com.studentapp.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.studentapp.model.dao.ProductRepo;
import com.studentapp.model.dao.ReviewRepo;
import com.studentapp.model.service.ReviewService;
import com.studentapp.web.entities.Product;
import com.studentapp.web.entities.Review;
import com.studentapp.web.exceptions.ResourceNotFoundException;

@Service
@Primary
public class ReviewServiceImpl implements ReviewService {

	private ReviewRepo reviewRepo;
	private ProductRepo productRepo;

	@Autowired
	public void setReviewRepo(ReviewRepo reviewRepo) {
		this.reviewRepo = reviewRepo;
	}

	@Autowired
	public void setProductRepo(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}

	@Override
	public List<Review> getAllReviews(int productId) {
		Product product = productRepo.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("product with id  :" + productId + " not found"));
		return product.getReviews();
	}

	@Override
	public Review addReview(Review review) {
		return reviewRepo.save(review);
	}

	@Override
	public Review deleteReview(int reviewId) {
		Review productToBeDeleted = getReviewById(reviewId);
		reviewRepo.delete(productToBeDeleted);
		return productToBeDeleted;
	}

	@Override
	public Review getReviewById(int reviewId) {
		return reviewRepo.findById(reviewId)
				.orElseThrow(() -> new ResourceNotFoundException("review with id : " + reviewId + " not found"));
	}

}
