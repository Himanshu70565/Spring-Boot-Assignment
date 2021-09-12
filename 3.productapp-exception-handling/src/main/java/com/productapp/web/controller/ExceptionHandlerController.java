package com.productapp.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.web.exceptions.ErrorDetails;
import com.productapp.web.exceptions.ProductNotFoundException;

@RestController
@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorDetails> handle404(Exception ex) {
		ErrorDetails errorDetail = new ErrorDetails();
		errorDetail.setEmail("jhimanshu9922@gmail.com");
		errorDetail.setMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetail);
	}
	
}
