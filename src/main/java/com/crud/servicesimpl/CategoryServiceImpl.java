package com.crud.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.crud.entity.Category;
import com.crud.repository.CategoryRepo;
import com.crud.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService  {

	@Autowired
	CategoryRepo categoryRepo;
	
	@Override
	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category getCategoryById(long id) {
		
		return categoryRepo.findById(id).get();
	}

	@Override
	public List<Category> getAllCategories(int pageno, int pagesize) {
		Pageable pageable= PageRequest.of(pageno, pagesize);
		
		Page<Category> CategoryPage= categoryRepo.findAll(pageable);	
		
		return CategoryPage.getContent();
	
	}

	@Override
	public Category updateCategory(long id, Category category) {
		Category category2=categoryRepo.findById(id).get();
		category2.setName(category.getName());
		return categoryRepo.save(category2);
	}

	@Override
	public void deleteCategory(long id) {
		categoryRepo.deleteById(id);
		
	}

}
