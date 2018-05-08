package com.shubham.shoppershub.dao;

import java.util.List;

import com.shubham.shoppershub.domain.User;


public interface UserDAO 
{

	//1.save the record
	//if the record is successfully saved - return true else false
	public boolean save(User user);
	
	//2.delete the records
	public boolean delete(String emailID);
	
	//3.update the records
	public boolean update(User user);
	
	//4.get the record based on emailid
	public User get(String emailID);
	
	//Upto this point i.e. get func is common in all;
	
	
	//5. get all records
	public List<User> list();
	
	//6. validate
	//At present we are not using spring security
	//When we use spring security, we will remove this method.
	public User validate(String emailID, String password);
}



















