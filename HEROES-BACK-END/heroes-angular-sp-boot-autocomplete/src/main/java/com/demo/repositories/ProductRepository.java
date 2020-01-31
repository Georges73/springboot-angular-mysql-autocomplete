package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Product;

@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Product, Long> {

	@Query("SELECT name FROM Product where name like %:keyword%")
	public List<String> search(@Param("keyword") String keyword);
	
	
	
	@Query("SELECT name FROM Product where id like %:keyword%")
	public Product searchFull(@Param("keyword") Long keyword);
	
	
	 //@RestResource(path = "name", rel="name")
	    @Query("from Product h where lower(h.name) like CONCAT('%', lower(:contains), '%')")
	    public Iterable<Product> findByName(@Param("contains") String name);  
	
	
	 
	    @Query("from Product h where lower(h.description) like CONCAT('%', lower(:contains), '%')")
	    public Iterable<Product> findByDescription(@Param("contains") String description);  
	  
	
	Iterable<Product> findAll();
	
	
	//public List<Hero> searchFull(@Param("keyword") String keyword);
	
	


	//public List<Product> searchDetail(String keyword);

}