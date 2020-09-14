package com.melvault.Product.respitory;


import org.springframework.data.jpa.repository.JpaRepository;

import com.melvault.Product.entity.Product;

public interface Repository extends JpaRepository<Product, Integer>{

}
