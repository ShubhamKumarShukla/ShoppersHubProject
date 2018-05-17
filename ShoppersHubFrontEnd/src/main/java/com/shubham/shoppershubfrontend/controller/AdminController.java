package com.shubham.shoppershubfrontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shubham.shoppershub.dao.CategoryDAO;
import com.shubham.shoppershub.dao.ProductDAO;
import com.shubham.shoppershub.dao.UserDAO;
import com.shubham.shoppershub.domain.Category;
import com.shubham.shoppershub.domain.Product;
import com.shubham.shoppershub.domain.User;

@Controller
public class AdminController 
{
	@Autowired
	private CategoryDAO categorydao;
	
	@Autowired
	private Category category;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private User user;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Product product;
	
	@Autowired
	private HttpSession httpsession;
	
	@GetMapping("/manage_categories")
	public ModelAndView manageCategories()
	{
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isAdminClickedManageCategories", true);
		List<Category> categories = categorydao.list();
		httpsession.setAttribute("categories", categories);
		return mv;
	}
	
	@GetMapping("/manage_suppliers")
	public ModelAndView manageSuppliers()
	{
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isAdminClickedManageSupplires", true);
		List<User> suppliers = userDAO.list('S');
		httpsession.setAttribute("suppliers", suppliers);
		return mv;
	}
	
	@GetMapping("/manage_products")
	public ModelAndView manageProducts()
	{
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isAdminClickedManageProducts", true);
		List<Product> products = productDAO.list();
		httpsession.setAttribute("products", products);
		return mv;
	}
}















