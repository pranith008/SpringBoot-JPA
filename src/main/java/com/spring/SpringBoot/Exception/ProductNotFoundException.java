package com.spring.SpringBoot.Exception;

public class ProductNotFoundException extends RuntimeException {
	
	public  ProductNotFoundException(String message) {
		super(message);
	}
}
