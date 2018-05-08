package com.shubham.shoppershub.dao.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.shoppershub.dao.ProductDAO;
import com.shubham.shoppershub.domain.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	/*@Autowired
	private Product product;*/

	public boolean save(Product product) 
	{
		try 
		{
			product.setAdded_date(new Date(System.currentTimeMillis()));
			sessionFactory.getCurrentSession().save(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
		
	}

	public boolean delete(String id) 
	{		
		try 
		{
			Product product = get(id);
			if(product==null)
			{
				return false;
			}
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
		
	}

	public boolean update(Product product) 
	{
		try 
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
	}

	public Product get(String id) 
	{		
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}

	public List<Product> list() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery(" from Product").list();
	}
	
}
