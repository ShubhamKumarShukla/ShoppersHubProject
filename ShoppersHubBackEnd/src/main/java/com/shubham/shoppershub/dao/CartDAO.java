package com.shubham.shoppershub.dao;

import java.util.List;

import com.shubham.shoppershub.domain.Cart;

public interface CartDAO 
{
	public boolean save(Cart cart);

	public boolean delete(int id);

	public boolean update(Cart cart);
	
	public boolean update(List<Cart> carts, char status);

	//get my products which is added to my cart
	//select * from Cart where emailID = ?
	public List<Cart> list(String emailID);
	
	//get cart by cart id;
	public Cart get(int id);
	 
}
