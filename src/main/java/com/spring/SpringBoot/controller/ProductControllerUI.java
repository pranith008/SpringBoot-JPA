package com.spring.SpringBoot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
		return "getAllProducts";	
	}
	
	@RequestMapping("/add-new-product")
	public String addNewProduct(Model model) {
		Product p1=new Product();
		model.addAttribute("product",p1);
		return "addNewProductForm";	
	}
	
	@RequestMapping("/add-new-product1")
	public String addNewProduct1(Model model) {
		Product p1=new Product();
		model.addAttribute("product",p1);
		return "addNewProductForm2";	
	}
	
	@PostMapping("/addSingleProduct")
	public String saveProduct(@ModelAttribute Product product)
	{
		productservice.saveProduct(product);
		return "redirect:/show-all-products";
	}
	
	@PostMapping("/addSingleProduct1")
	public String saveProduct1(@ModelAttribute Product product, @RequestParam("imageFile") MultipartFile file) throws IOException
	{
		
		if (!file.isEmpty()) {

	        String uploadDir = "uploads/";
	        Files.createDirectories(Paths.get(uploadDir));

	        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
	        Path filePath = Paths.get(uploadDir, fileName);

	        Files.write(filePath, file.getBytes());

	        // Save only filename or relative path
	        product.setImage("http://localhost:8085/uploads/" + fileName);
	    }
		productservice.saveProduct(product);
		return "redirect:/show-all-products";
	}
	
	@RequestMapping("/deleteProductUI/{pid}")
	public String deleteProductUI(@PathVariable int pid)
	{
		productservice.deleteProduct(pid);
		return "redirect:/show-all-products";
	}
	
	@RequestMapping("/updateProductFormFE/{pid}")
	public String updateProductUI(@PathVariable int pid, Model model)
	{
	Product product=productservice.getSingle(pid);
	model.addAttribute("product",product);
	return "updateProductForm";
	}
	
	@PostMapping("/updateProductFE/{prodId}")
	public String updateProductUI(@PathVariable int prodId, @ModelAttribute Product product)
	{
	productservice.updateProduct(prodId, product);
	return "redirect:/show-all-products";
	}
	
}
