package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entities.Product;
import com.demo.repositories.ProductRepository;

@Transactional
@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<String> search(String keyword) {
		// System.err.println("-------------My keyword is " + keyword);
		return productRepository.search(keyword);
	}

	@Override
	public Product searchFull(Long keyword) {
		List<Product> result = null;

		return productRepository.searchFull(keyword);
	}

	@Override
	public Iterable<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	@Override
	public List<String> findByNameStartingWith(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Product> findByName(String name) {

		System.err.println("TERM ***************** " + name);
		return productRepository.findByName(name);
	}

	@Override
	public Iterable<Product> findByDescription(String description) {
		// TODO Auto-generated method stub
		return productRepository.findByName(description);
	}

	/*
	 * @Override public Product save(Product product) { return
	 * productRepository.save(product);
	 * 
	 * }
	 */

}