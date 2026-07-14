package com.spring.SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.SpringBoot.Exception.ProductNotFoundException;
import com.spring.SpringBoot.entity.Product;
import com.spring.SpringBoot.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productservice;
	
	@PostMapping("/save-single-product")
	public ResponseEntity<Product> saveSingleProduct(@RequestBody Product product) 
	{
		Product savedProduct=productservice.saveProduct(product);
		return new ResponseEntity<Product>(savedProduct,HttpStatus.CREATED);
	}
	
	@PostMapping("/save-multiple-products")
	public ResponseEntity<List<Product>> saveMultipleProduct(@RequestBody List<Product> products) 
	{
		return new ResponseEntity<List<Product>>(productservice.saveMultiple(products),HttpStatus.CREATED);
	}
	
	@GetMapping("/get-single-product/{productid}")
	public ResponseEntity<Product> getSingleProduct(@PathVariable int productid) 
	{
		return new ResponseEntity<Product>(productservice.getSingle(productid),HttpStatus.OK);
	}
	
	@GetMapping("/get-multiple-products")
	public ResponseEntity<List<Product>> getMultipleProduct() 
	{
		return new ResponseEntity<List<Product>>(productservice.getMultiple(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-product/{productid}")
	public ResponseEntity<String> deleteProduct(@PathVariable int productid) 
	{
		try {
			productservice.deleteProduct(productid);
			return new ResponseEntity<String>("The product with id "+productid+" is deleted",HttpStatus.OK);
		}
		catch(ProductNotFoundException ex){
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.OK);
		}
	}
	
	@PutMapping("/update-product/{productid}")
	public ResponseEntity<?> updateProduct(@PathVariable int productid,@RequestBody Product product) 
	{
		try {
			return new ResponseEntity<Product>(productservice.updateProduct(productid,product),HttpStatus.OK);
		}
		catch(ProductNotFoundException ex){
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.OK);
		}
	}
	
	
	
	
}
