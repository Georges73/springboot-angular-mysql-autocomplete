package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.demo.entities.Product;

public interface ProductService {

	public List<String> search(String keyword);

	//List<Product> searchDetail(String keyword);

	Product searchFull(Long id);

	Iterable<Product> findAll();
	
	Optional<Product> findById(Long id);
	
	List<String> findByNameStartingWith(String prefix);

	public Iterable<Product> findByName(String name);
	
	public Iterable<Product> findByDescription(String description);

	//public String findAll();
	
	

	//Product save(Product product);

}