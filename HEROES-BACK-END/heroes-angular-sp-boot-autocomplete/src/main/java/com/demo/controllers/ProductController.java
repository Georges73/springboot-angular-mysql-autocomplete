package com.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Product;
import com.demo.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")

@Api(value = "Product Rest Controller: contains all operations for managing products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/getAllProducts")
	// @ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Get All products from DB", response = Product.class)
	@ApiResponse(code = 409, message = "Conflict: SOmething went wrong")
	public @ResponseBody Iterable<Product> allProducts() {

		return productService.findAll();
	}

	@GetMapping(value = "/searchByName{name}", produces = "application/json")
	// @ResponseStatus(HttpStatus.OK)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: successfull research"),
			@ApiResponse(code = 204, message = "No Content: no result founded"), })
	public Iterable<Product> searchByName(@RequestParam("name") String name) {

		System.err.println("searchByName  ");

		// Gson gson = new Gson();

		return productService.findByName(name);
	}

	@GetMapping("/searchByID{id}")
	@ResponseBody
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: successfull research by ID"),
			@ApiResponse(code = 204, message = "No Content: no result founded by ID"), })

	public Optional<Product> findById(@RequestParam("id") Long id) {
		System.err.println("--------------SEARCH BY ID---------------------" + id);

		// Gson gson = new Gson();

		return productService.findById(id);
	}

}