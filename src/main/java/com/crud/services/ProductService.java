package com.crud.services;

import java.util.List;

import com.crud.entity.Product;

public interface ProductService {
public Product addProduct(Product product);
	
	public Product getProductById(long id);
	
	public List<Product> getAllProducts(int pageno, int pagesize);
	
	public Product updateProduct(long id, Product product);
	
	public void deleteProduct(long id);

}
