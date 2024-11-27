package com.crud.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.crud.entity.Product;

import com.crud.repository.ProductRepo;
import com.crud.services.ProductService;

@Service
public class ProductServiceImp implements ProductService{

	@Autowired
	ProductRepo productRepo;
	
	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Product getProductById(long id) {
		
		return productRepo.findById(id).get();
	}

	@Override
	public List<Product> getAllProducts(int pageno, int pagesize) {
		Pageable pageable= PageRequest.of(pageno, pagesize);
		
		Page<Product> productsPage= productRepo.findAll(pageable);	
		
		return productsPage.getContent();
	}

	@Override
	public Product updateProduct(long id, Product product) {
		Product product2=productRepo.findById(id).get();
		product2.setName(product.getName());
		product2.setPrice(product.getPrice());
		return productRepo.save(product2);
	}

	@Override
	public void deleteProduct(long id) {
		productRepo.deleteById(id);
		
	}

}
