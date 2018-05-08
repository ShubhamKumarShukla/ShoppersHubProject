package com.shubham.shoppershubfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//converting this class into Servlet/Controller
@Controller
public class HomeController 
{
	@GetMapping("/")
	public String homePage()
	{
		return "Home";
	}
	
	@GetMapping("/login")	
	public ModelAndView login()
	{
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isUserClickedLogin", true);
		return mv;

	}
	
}
