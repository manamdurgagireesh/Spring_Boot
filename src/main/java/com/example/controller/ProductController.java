package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ProductDAO;
import com.example.dao.ProductRepository;
import com.example.entity.Product;


@RestController
public class ProductController 
{

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductDAO productDAO;

	@GetMapping("/getProductDetails")
	public ResponseEntity<List<Product>> getProductDetails()
	{
		List<Product> productList=productDAO.getProductList();
		return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
	}
	
	@PostMapping("/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody Product product)
	{
		productRepository.save(product);
		//productDAO.addProduct(product);
		return new ResponseEntity<String>("ProductAdded",HttpStatus.OK);
	}
	
	@GetMapping("/getProduct/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId")int productId)
	{
		Product product=productDAO.getProduct(productId);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@GetMapping("/deleteProduct/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId")int productId)
	{
		productDAO.deleteProduct(productId);
		return new ResponseEntity<String>("ProductDeleted",HttpStatus.OK);
	}
	
	
}