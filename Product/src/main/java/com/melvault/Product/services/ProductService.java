package com.melvault.Product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melvault.Product.entity.Product;
import com.melvault.Product.respitory.Repository;

@Service
public class ProductService {
    @Autowired
	private Repository repo;
	
	public List<Product> listAll(){
		return repo.findAll();
	}
	
	
	public Product save(Product product){
		return repo.save(product);
	}
	
	public Product get(Integer id){
		return repo.findById(id).get();
	}
	
	public Product delete(Integer id){
	 repo.deleteById(id);
	return null;

	}
	
}
