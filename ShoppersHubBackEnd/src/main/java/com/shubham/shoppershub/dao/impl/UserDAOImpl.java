package com.shubham.shoppershub.dao.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.shoppershub.dao.UserDAO;
import com.shubham.shoppershub.domain.User;


@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO 
{

	//Get the Session Factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private User user;
	
	public boolean save(User user) 
	{

		try 
		{
			//set current date
			user.setAdded_date(new Date(System.currentTimeMillis()));
			sessionFactory.getCurrentSession().save(user);
			// above line: opening session saving saving user in user table.
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public boolean delete(String emailID) 
	{		
		try 
		{	
			user = get(emailID);
			if(user==null)
			{
				return false;
			}
			sessionFactory.getCurrentSession().delete(user);
			// above line: opening session saving saving user in user table.
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public boolean update(User user) 
	{
		try 
		{
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) 
		{
			// if any exceptions, the complete error stack trace will print on the console
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public User get(String emailID) 
	{		
		return (User) sessionFactory.getCurrentSession().get(User.class, emailID);
	}

	public List<User> list() 
	{
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public User validate(String emailID, String password) 
	{
		// select * from User where emailID = ? and password = ?
		return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
		.add(Restrictions.eq("emailID", emailID))
		.add(Restrictions.eq("password", password)).uniqueResult();
	}

}
