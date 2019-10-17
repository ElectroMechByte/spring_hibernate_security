package com.training.service;

import java.util.List;

import com.training.model.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(String productId);

	void deleteProduct(String productId);

	void addProduct(Product product);
	
	void editProduct(Product product);
}
