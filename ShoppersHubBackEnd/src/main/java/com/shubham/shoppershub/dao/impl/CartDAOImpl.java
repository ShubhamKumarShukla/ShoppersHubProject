package com.shubham.shoppershub.dao.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.shoppershub.dao.CartDAO;
import com.shubham.shoppershub.domain.Cart;


@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	private int getMaxValue()
	{
		//check what is the max value of id in cart
		try 
		{
			int maxValue = (Integer) sessionFactory.getCurrentSession()
								 .createQuery("select max(id) from Cart")
								 .uniqueResult();
			return maxValue+1;
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return 100;
		}
	}

	public boolean save(Cart cart) 
	{
		try 
		{
			//set today's date
			cart.setAdded_date(new Date(System.currentTimeMillis()));
			
			//set status as 'N'
			cart.setStatus('N');
			
			//set quantity as 1 if not given by customer
			if(cart.getQuantity()==0)
			{
				cart.setQuantity(1);
			}
			
			cart.setId(getMaxValue());
			
			// get the price from product, set the price
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(int id) 
	{
		try 
		{
			//before deleting check whether it exist or not
			//if it does not exist, return false
			Cart cart = get(id);
			if(cart==null)
			{
				return false;
			}
			else
			{
				sessionFactory.getCurrentSession().delete(cart);
				return true;
			}
			
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}

	}

	public boolean update(Cart cart) 
	{
		try 
		{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} 
		catch (HibernateException e) 
		{
			e.printStackTrace();
			return false;
		}

	}

	/*
	 * public Cart get(int id) { String ID = String.valueOf(id); return (Cart)
	 * sessionFactory.getCurrentSession().get(ID, Cart.class); }
	 */

	public List<Cart> list(String emailID) 
	{
		// select * from cart where emailid = ? and status = 'N'
		return sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.add(Restrictions.eq("emailID", emailID))
				.add(Restrictions.not(Restrictions.eq("status", 'L'))).list();
	}

	public Cart get(int id)
	{
		return sessionFactory.getCurrentSession().get(Cart.class, id);
	}

	public boolean update(List<Cart> carts,char status) 
	{	
		try 
		{
			for(Cart cart : carts)
			{
				cart.setStatus(status);
				update(cart);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}	
	
}
