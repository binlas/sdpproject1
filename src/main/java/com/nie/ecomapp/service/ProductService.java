package com.nie.ecomapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nie.ecomapp.entity.Product;
import com.nie.ecomapp.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	
	public Product saveProduct(Product product) {
		product.setId(null);
		return productRepository.save(product);
	}
	
	public Product getProductById(String id) {	
		return productRepository.findById(id).get();
	}
	
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	public boolean deleteProduct(String id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isEmpty()) {
			return false;
		}
		productRepository.deleteById(id);
		return true;
	}
	
	public Product updateProduct(Product product, String id) {
		Product existingProduct = productRepository.findById(id).get();
		
		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setTags(product.getTags());
		existingProduct.setStock(product.getStock());
		
		return productRepository.save(existingProduct);
	}
	
	
	
}
