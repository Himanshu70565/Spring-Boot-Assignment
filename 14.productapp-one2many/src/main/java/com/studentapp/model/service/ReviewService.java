package com.studentapp.model.service;

import java.util.List;

import com.studentapp.web.entities.Review;

public interface ReviewService {
	public List<Review> getAllReviews(int productId);
	public Review addReview(Review review);
	public Review deleteReview(int reviewId);
	public Review getReviewById(int reviewId);
}
