package com.shubham.shoppershub.dao;

import java.util.List;

import com.shubham.shoppershub.domain.Product;

public interface ProductDAO 
{
	public boolean save(Product product);

	public boolean delete(String id);

	public boolean update(Product product);

	public Product get(String id);
	
	public List<Product> list();
	
	/*//search all product under certain amount
	public List<Product> list(int amt);
	
	//search all product between a minimum amt to maximum amt
	public List<Product> list(int minAmt, int maxAmt);
	
	//search for a particular product where the product is between 10k - 20k and belongs to a paricular company
	public List<Product> list(String productName, int minAmt, int maxAmt);*/

}
