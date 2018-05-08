package com.shubham.shoppershub;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.shoppershub.dao.CartDAO;
import com.shubham.shoppershub.domain.Cart;

import junit.framework.Assert;

public class CartDAOTestCase 
{
	private static AnnotationConfigApplicationContext context;
	private static CartDAO cartDAO;
	private static Cart cart;
	
	@BeforeClass
	public static void initialize()
	{	
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shubham");
		context.refresh();
		
		cartDAO = (CartDAO) context.getBean("cartDAO");
		cart = (Cart) context.getBean("cart");
	}
	
	@Test
	public void addToCartTestCase()
	{
		cart.setEmailID("Steve@gmail.com");
		cart.setProductName("Nokia 7 plus");
		cart.setPrice(35000);				//should get from product table
		//cart.setAdded_date(added_date);		//default should be today
		cart.setQuantity(5);  				//default should be 1
		//cart.setStatus(status);				//default 'N'
		Assert.assertEquals(true, cartDAO.save(cart));
	}
	
	@Test
	public void updateCartTestCase()
	{
		Cart cart = cartDAO.get(0);
		cart.setQuantity(1);
		boolean actual = cartDAO.update(cart);
		
	}
	
	@Test
	public void getCartSuccessTestCase()
	{
		Assert.assertNotNull(cartDAO.get(0));
	}
	
	@Test
	public void getCartFailTestCase()
	{
		Assert.assertNull(cartDAO.get(10));
	}
	
	@Test
	public void deleteCartTestCase()
	{
		Assert.assertEquals(true, cartDAO.delete(3));
	}
	
	@Test 
	public void productDispatchedTestCase()
	{
		cart=	cartDAO.get(2);
		cart.setStatus('D');
		Assert.assertEquals(true,cartDAO.update(cart));
	}
	
	@Test 
	public void dispatchAllTheProductsTestCase()
	{
		List<Cart> carts = 	cartDAO.list("Steve@gmail.com");
		Assert.assertEquals(true,cartDAO.update(carts,'D'));	
	}
	
	@Test 
	public void deliverAllTheProductsTestCase()
	{
		List<Cart> carts = 	cartDAO.list("Steve@gmail.com");
		Assert.assertEquals(true,cartDAO.update(carts,'L'));
	}
	
}









