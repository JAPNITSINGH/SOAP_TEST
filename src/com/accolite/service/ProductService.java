package com.accolite.service;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

	private static List<Product> listOfProducts = new ArrayList<Product>();

	public ProductService() {
		
		listOfProducts.add(new Product(1, "Apple"));
		listOfProducts.add(new Product(2, "Banana"));
		listOfProducts.add(new Product(3, "Carrot"));
		listOfProducts.add(new Product(4, "Drum Sticks"));
	}

	public Product searchByID(int id) {
		for (Product p : listOfProducts) {
			if (p.getId() == id)
				return p;
		}
		Product x = new Product(0, "No Product Found");
		return x;
	}

//	public List<Product> getAllProducts() {
//		System.out.println("Inside getallproducts");
//		return listOfProducts;
//	}

	public Product[] getAllProducts() {
		Product[] products = new Product[listOfProducts.size()];
		int i = 0;

		for (Product p : listOfProducts) {
			products[i] = p;
			i++;
		}

		return products;
	}
	
	public boolean deleteProduct(Product p)
	{
		return listOfProducts.remove(p);
	}
	
	public boolean updateProduct(Product p)
	{
		for(Product x : listOfProducts)
		{
			if( x.getId() == p.getId())
			{
				p.setName(x.getName());
			}
				
		}
		return true;
	}

	public boolean insertProduct(Product p) {
		return listOfProducts.add(p);
	}
}
