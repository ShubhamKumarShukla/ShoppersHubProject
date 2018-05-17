package com.shubham.shoppershubfrontend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shubham.shoppershub.dao.CategoryDAO;
import com.shubham.shoppershub.domain.Category;

@Controller
public class CategoryController 
{
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	@Autowired
	private HttpSession httpsession;
	
	
}




















