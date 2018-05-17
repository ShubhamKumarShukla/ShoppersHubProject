package com.shubham.shoppershub;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.shoppershub.dao.UserDAO;
import com.shubham.shoppershub.domain.User;

import junit.framework.Assert;

public class UserDAOTestCase 
{
	//you supposed to get UserDAO Bean, so that you can call
	//save/update/delte/get/validate methods
	
	//context.getBean("userDAO")
	// you supposed to get bean only once
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private static User user;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shubham");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
		user = (User) context.getBean("user");
	}
	
	
	@Test
	public void saveUserTestCase()
	{
		user.setEmailID("Phil@gmail.com");
		user.setName("Phil Coulson");
		user.setPassword("phil@123");
		user.setRole('S');
		user.setMobile("1111111111");
		user.setAddress("Helicarrier");
		
		boolean result = userDAO.save(user);
		Assert.assertEquals("Save user", true, result);
	}
	
	@Test
	public void validateCredentialsSuccess()
	{
		user = userDAO.validate("Bruce@gmail.com", "Bruce@123");
		Assert.assertNotNull("Validated Credentials", user);
	}
	
	@Test
	public void validateCredentialsFailure()
	{
		user = userDAO.validate("Clint@gmail.com", "Clint@1234");
		Assert.assertNull("Validated Credentials", user);
	}
	
	
	@Test
	public void deleteUserSuccessTestCase()
	{
		boolean actual = userDAO.delete("asd@gmail.com");
		Assert.assertEquals(" delete user test case",true, actual);
	}
	
	@Test
	public void deleteUserFailureTestCase()
	{
		boolean actual = userDAO.delete("Peter@gmail.com");
		Assert.assertEquals(" delete user test case",false, actual);
	}
	
	
	@Test
	public void updateUserTestCase()
	{
		user = userDAO.get("Steve@gmail.com");
		user.setAddress("Brooklyn, New York");
//		user.setAdded_date(added_date);
		boolean actual = userDAO.update(user);
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void getAllUsers()
	{
		int size = userDAO.list().size();
		Assert.assertEquals(4, size);
	}
	

	@Test
	public void getUserTestCase()
	{
		user=	userDAO.get("Steve@gmail.com");
		Assert.assertNotNull(user);
	}
	
}












