package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.entity.Product;

@Repository("productDAO")
public class ProductDAO 
{
	ArrayList<Product> productList=new ArrayList<Product>();
	
	public void addProduct(Product product)
	{
		productList.add(product);
	}
	
	public void deleteProduct(int productId)
	{
		int pos=0;
		Product product=null;
		while(pos<productList.size())
		{
			product=productList.get(pos);
			if(product.getProductid()==productId)
			{
				break;
			}
			pos++;
		}
		
		if(product!=null)
			productList.remove(product);
	}
	
	public Product getProduct(int productId) {
		int pos=0;
		Product product=null;
		while(pos<productList.size())
		{
			product=productList.get(pos);
			if(product.getProductid()==productId)
			{
				break;
			}
			pos++;
		}
		
		return product;
	}
	
	public List<Product> getProductList()
	{
		return productList;
	}
}