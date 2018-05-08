package com.shubham.shoppershub.dao.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.shoppershub.dao.CategoryDAO;
import com.shubham.shoppershub.domain.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	/*@Autowired
	private Category category;*/

	public boolean save(Category category) 
	{
		try 
		{
			category.setAdded_date(new Date(System.currentTimeMillis()));
			sessionFactory.getCurrentSession().save(category);
			return true;
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delete(String name) 
	{
		try 
		{
			//before deleting check whether the record exist or not
			//if record doesn't exist , return false
			Category category = get(name);
			if(category==null)
			{
				return false;
			}
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} 		
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Category category) 
	{
		try 
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}
		
	}

	public Category get(String name) 
	{
		return (Category) sessionFactory.getCurrentSession().get(Category.class,name);
	}

	public List<Category> list() 
	{
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	
}
