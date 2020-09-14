package com.melvault.Product.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.melvault.Product.entity.Product;
import com.melvault.Product.services.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/Product")
public class ProductController {

	@Autowired
	private ProductService service;
	
	// All product list
	@GetMapping("/All")
	public List<Product> list(){
		return service.listAll();
	}
	
	//Product listByid
	@GetMapping("{id}")
	public ResponseEntity<Product> get(@PathVariable Integer id){
		try {
			Product product=service.get(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);

		}
		
	}
	
	//Add product
	@PostMapping("/add")
	public void add(@RequestBody Product product) {
		service.save(product);
	}
	
	//update productbyId
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> update(@RequestBody Product product,@PathVariable Integer id){
		try {
			Product existproduct=service.get(id);
			service.save(product);
			
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		
		}catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);

		}
		
	}
	
	//delete productById
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Product> delete(@PathVariable Integer id) {
		try {
		
		     Product product=service.delete(id);
		      return new ResponseEntity<Product>(product,HttpStatus.OK);
	     }catch (NoSuchElementException e) {
		      return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);

		     }
	}


}
