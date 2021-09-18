package com.studentapp.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentapp.web.entities.Review;


@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer>{

}
