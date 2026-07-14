package com.spring.SpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.SpringBoot.entity.Product;
import com.spring.SpringBoot.service.ProductService;

@Controller
public class ProductControllerUI {
	
	@Autowired
	ProductService productservice;
	
	@RequestMapping("/show-all-products")
	public String showAllProducts(Model model) {
		List<Product> products=productservice.getMultiple();
		model.addAttribute("products",products);
		return "products";
		
	}
	
}
