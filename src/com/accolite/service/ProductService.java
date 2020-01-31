package com.accolite.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;

public class ProductService {
	final static Logger logger = LogManager.getLogger(ProductService.class.getName());
	private  List<Product> listOfProducts = new ArrayList<Product>();

	public ProductService() {
		 Configurator.initialize(new DefaultConfiguration());
		    Configurator.setRootLevel(Level.INFO);
		listOfProducts.add(new Product(1, "Apple"));
		listOfProducts.add(new Product(2, "Banana"));
		listOfProducts.add(new Product(3, "Carrot"));
		listOfProducts.add(new Product(4, "Drum Sticks"));
		logger.info("Constructor Successful");
	}

	public Product searchByID(int id) {
		for (Product p : listOfProducts) {
			if (p.getId() == id)
				{	logger.info("Search Complete , Element  found");
					return p;
				}
		}
		Product x = new Product(0, "No Product Found");
		logger.info("Search Complete , Element not found");
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
		logger.info("Extracted products ");
		return products;
	}
	
	public boolean deleteProduct(Product p)
	{	
		for(int i = 0 ; i <  listOfProducts.size() ; i++)
		{
			if( listOfProducts.get(i).getId() == p.getId())
				 {
					listOfProducts.remove(i);
					logger.info("Delete successful");
					return true;
				 }
		}
		//return listOfProducts.remove(p);
		logger.info("Delete failed");
		return false;
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
		logger.info("Update successful");
		return true;
	}

	public boolean insertProduct(Product p) {
		return listOfProducts.add(p);
	}
}
