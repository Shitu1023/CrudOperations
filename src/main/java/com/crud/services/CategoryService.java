package com.crud.services;

import java.util.List;

import com.crud.entity.Category;

public interface CategoryService {
	
	public Category addCategory(Category category);
	
	public Category getCategoryById(long id);
	
	public List<Category> getAllCategories(int pageno, int pagesize);
	
	public Category updateCategory(long id, Category category);
	
	public void deleteCategory(long id);
	
	

}
