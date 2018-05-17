package com.shubham.shoppershubfrontend.controller;

import javax.servlet.http.HttpSession;

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
	
	@Autowired
	private HttpSession httpsession;
	
	
	@PostMapping("/validate")
	public ModelAndView validate(@RequestParam String emailID, @RequestParam String password)
	{
		
		ModelAndView mv = new ModelAndView("Home");
		user = userDAO.validate(emailID, password);
		if(user!=null)
		{
			mv.addObject("msg", "Welcome Mr. "+user.getName());
			if(user.getRole()=='A')
			{
				//mv.addObject("isAdmin", true);
				httpsession.setAttribute("isAdmin", true);
			}
			else if(user.getRole()=='C')
			{
				//mv.addObject("isUser", true);
				httpsession.setAttribute("isUser", true);
			}
			else if(user.getRole()=='S')
			{
				//mv.addObject("isSupplier", true);
				httpsession.setAttribute("isSupplier", true);
			}
		}
		else
		{
			mv.addObject("msg", "Invalid Email ID or Password");
		}
		
		return mv;
	}

	
}
