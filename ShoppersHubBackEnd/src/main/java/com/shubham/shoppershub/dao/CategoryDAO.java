package com.shubham.shoppershub.dao;

import java.util.List;

import com.shubham.shoppershub.domain.Category;

public interface CategoryDAO 
{
	public boolean save(Category category);

	public boolean delete(String name);

	public boolean update(Category category);

	public Category get(String name);
	
	//select * from Category
	public List<Category> list();
}
