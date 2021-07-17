package com.example.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Product;
@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Product,Integer> {

}