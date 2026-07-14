package com.spring.SpringBoot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@RequestMapping("/test")  //endpoint
	public String test()
	{
		return "This is my first springboot";
	}
}
