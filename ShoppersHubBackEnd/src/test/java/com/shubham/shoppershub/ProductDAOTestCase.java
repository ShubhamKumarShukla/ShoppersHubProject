package com.shubham.shoppershub;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.shoppershub.dao.ProductDAO;
import com.shubham.shoppershub.domain.Product;

import junit.framework.Assert;

public class ProductDAOTestCase
{
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private static Product product;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shubham");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		product = (Product) context.getBean("product");
	}
	
	@Test
	public void saveProductTestCase()
	{
		product.setId("PRD_MOB_004");
		product.setName("Nokia 8 Sirocco");
		product.setDescription("The new Nokia phone Nokia 8 Sirocco");
		product.setPrice(35500);
		product.setCategory_name("Electronics");
		
		boolean result = productDAO.save(product);
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void updateProductSuccessTestCase()
	{
		product = productDAO.get("PRD_MOB_004");
		product.setPrice(49999);
		boolean actual = productDAO.update(product);
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void updateProductFailureTestCase()
	{

		product = productDAO.get("PRD_MOB_009");
		Assert.assertNotNull(product);
		product.setDescription("New Nokia Mobile.");
		boolean actual = productDAO.update(product);
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void getProductSuccessTestCase()
	{
		Assert.assertNotNull(productDAO.get("PRD_MOB_004"));
	}
	
	@Test
	public void getProductFailureTestCase()
	{
		Assert.assertNull(productDAO.get("PRD_MOB_009"));
	}
	
	@Test
	public void deleteProductSuccessTestCase()
	{
		Assert.assertEquals(true, productDAO.delete("PRD_MOB_004"));
	}
	
	@Test
	public void deleteProductFailureTestCase()
	{
		Assert.assertEquals(false, productDAO.delete("asd"));
	}
	
	@Test
	public void getAllProductsTestCase()
	{
		Assert.assertEquals(3, productDAO.list().size());
	}
}
