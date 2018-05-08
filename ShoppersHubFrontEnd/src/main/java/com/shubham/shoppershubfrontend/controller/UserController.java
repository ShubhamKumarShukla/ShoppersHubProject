package com.shubham.shoppershubfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shubham.shoppershub.dao.UserDAO;
import com.shubham.shoppershub.domain.User;

@Controller
public class UserController 
{
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private User user;
	
	@PostMapping("/validate")
	public ModelAndView validate(@RequestParam String id, @RequestParam String password)
	{
		ModelAndView mv = new ModelAndView("Home");
		user = userDAO.validate(id, password);
		if(user!=null)
		{
			mv.addObject("msg", "Welcome Mr. "+user.getName());
		}
		else
		{
			mv.addObject("msg", "Invalid Email ID or Password");
		}
		
		return mv;
	}
	
}
