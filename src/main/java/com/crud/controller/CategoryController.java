package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Category;
import com.crud.services.CategoryService;


@RestController
@RequestMapping("api/categories")
public class CategoryController {
	@Autowired
    private CategoryService categoryService;
	
	@PostMapping
	public Category addCategory( @RequestBody Category category)
	{
		return categoryService.addCategory(category);
	}
	
	@GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }


    @GetMapping
    public List<Category> getAllCategories(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
    	
        return categoryService.getAllCategories(page, size);
    }


    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

}
