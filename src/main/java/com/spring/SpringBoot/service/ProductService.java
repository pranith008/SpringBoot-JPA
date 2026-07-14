package com.spring.SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SpringBoot.Exception.ProductNotFoundException;
import com.spring.SpringBoot.entity.Product;
import com.spring.SpringBoot.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> saveMultiple(List<Product> products) {
		return  productRepository.saveAll(products);
	}

	public Product getSingle(int productid) {
		return productRepository.findById(productid).orElse(null);
	}

	public List<Product> getMultiple() {
		return productRepository.findAll();
	}

	public void deleteProduct(int productid) throws ProductNotFoundException{
		if(productRepository.existsById(productid)) {
			 productRepository.deleteById(productid);
		}
		else {
			throw new ProductNotFoundException("The product with id "+productid+" is not present");
		}
	}

	public Product updateProduct(int productid, Product product) throws ProductNotFoundException{
		if(productRepository.existsById(productid)) {
			 Product productdb=productRepository.findById(productid).orElse(null);
			 productdb.setCategory(product.getCategory());
			 productdb.setDescription(product.getDescription());
			 productdb.setImage(product.getImage());
			 productdb.setPrice(product.getPrice());
			 productdb.setTitle(product.getTitle());
			 return productRepository.save(productdb);
		}
		else {
			throw new ProductNotFoundException("The product with id "+productid+" is not present");
		}
	}
	
	

	

}
