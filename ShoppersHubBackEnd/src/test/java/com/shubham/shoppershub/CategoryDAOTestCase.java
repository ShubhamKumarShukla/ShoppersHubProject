package com.shubham.shoppershub;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shubham.shoppershub.dao.CategoryDAO;
import com.shubham.shoppershub.domain.Category;

import junit.framework.Assert;

public class CategoryDAOTestCase 
{
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private static Category category;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shubham");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		category = (Category) context.getBean("category");
	}
	
	@Test
	public void saveCategoryTestCase()
	{
		category.setName("XYZ");
		category.setDescription("BLAH! BLAH! BLAH! BLAH!");
		
		boolean result = categoryDAO.save(category);
		Assert.assertEquals("Save Category", true, result);
	}
	
	@Test
	public void updateCategorySuccessTestCase()
	{
		category = categoryDAO.get("TVs & Appliances");
		category.setDescription("Contains only TVs and Home Appliances. However, Mobiles and PCs are in Electronics.");
		boolean actual = categoryDAO.update(category);
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void updateCategoryFailureTestCase()
	{
		//books category doesn't exist yet
		//suppose to return null
		category = categoryDAO.get("Books");
		Assert.assertNotNull(category);
		category.setDescription("Contains only TVs and Home Appliances. Mobiles and PCs are in Electronics.");
		boolean actual = categoryDAO.update(category);
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void getCategorySuccessTestCase()
	{
		Assert.assertNotNull(categoryDAO.get("Electronics"));
	}
	
	@Test
	public void getCategoryFailureTestCase()
	{
		Assert.assertNull(categoryDAO.get("Books"));
	}
	
	@Test
	public void deleteCategorySuccessTestCase()
	{
		Assert.assertEquals(true, categoryDAO.delete("XYZ"));
	}
	
	@Test
	public void deleteCategoryFailureTestCase()
	{
		Assert.assertEquals(false, categoryDAO.delete("asd"));
	}
	
	@Test
	public void getAllCategoriesTestCase()
	{
		Assert.assertEquals(2, categoryDAO.list().size());
	}
}








