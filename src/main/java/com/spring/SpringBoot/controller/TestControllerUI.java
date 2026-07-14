package com.spring.SpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.SpringBoot.entity.Player;


@Controller //to return a webpage
public class TestControllerUI {
	
	@RequestMapping("/testui")  //endpoint
	public String testui()
	{
		return "test"; //there should be an html file by this name in the resources/templates folder
	}
	
	@RequestMapping("/rcb")
	public String rcb(Model model) {
		String playerName="Virat Kohli";
		model.addAttribute("player",playerName);
		return "test"; //there should be an html file by this name in the resources/templates folder
	}
	
	@RequestMapping("/mi")
	public String mi(ModelMap modelmap) {
		Player p1=new Player(45,"Rohit Sharma",100,6000);
		modelmap.addAttribute("player",p1);
		return "ipl";
	}
	
	@RequestMapping("/csk")
	public ModelAndView csk() {
		Player p1=new Player(7,"MS DHONI",200,5000);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("ipl");//there should be an html file by this name in the resources/templates folder
		mav.addObject("player",p1);
		return mav;
	}
	
	
}
