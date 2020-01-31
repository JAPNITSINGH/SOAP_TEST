package com.accolite.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;
import org.junit.Assert;
import org.junit.jupiter.api.Test;




class ProductServiceTest {
	
	final static Logger logger = LogManager.getLogger(ProductServiceTest.class.getName());
	private List<Product> listOfProducts = new ArrayList<Product>();
	//List<Product> p = new ArrayList<Product>;
	 
 	void init()
 	{	//BasicConfigurator.configure();
 		logger.info("init started");
 		listOfProducts.clear();
 		listOfProducts.add(new Product(1, "Apple"));
		listOfProducts.add(new Product(2, "Banana"));
		listOfProducts.add(new Product(3, "Carrot"));
		listOfProducts.add(new Product(4, "Drum Sticks"));
		logger.info("inti() finished"); 
 	}

	@Test
	void testSearchByID() {
		logger.info("testSearchByID() started");
		ProductService ps = new ProductService();
		Product expectedOutput = new Product(1, "Apple");
		Product obtainedOutput = ps.searchByID(1);
		Assert.assertEquals(obtainedOutput.getId(),expectedOutput.getId());
		logger.info("testSearchByID() finished");
	}

	@Test
	void testGetAllProducts() {
		logger.info("testGetAllProducts() started");
		init();
		Product[] expectedProducts = new Product[listOfProducts.size()];
		for(int i = 0 ; i < listOfProducts.size() ; i++)
		{
			expectedProducts[i] = listOfProducts.get(i);
		}
		ProductService ps = new ProductService();
		Product[] obtainedProducts = ps.getAllProducts();
		
		for(int i = 0 ; i < listOfProducts.size() ; i++)
		{
			if(obtainedProducts[i].getId() == expectedProducts[i].getId())
				continue;
			else
			{
				fail("testGetAllProducts() failed");
				break;
			}
		}
		logger.info("testGetAllProducts() finished");
	}

	@Test
	void testDeleteProduct() {
		logger.info("testDeleteProduct() started");
		init();
		ProductService ps = new ProductService();
		boolean expectedOutput = true;
		Product p = new Product(1,"Apple");
		boolean obtainedOutput = ps.deleteProduct(p);
//		if(expectedOutput && obtainedOutput)
//			logger.info("testDeleteProduct() success");//System.out.println("testDeleteProduct() Success");
//		else
//			fail("testDeleteProduct() failed");
		Assert.assertEquals(obtainedOutput,expectedOutput);
		logger.info("testDeleteProduct() finished");
	}


	@Test
	void testInsertProduct() {
		logger.info("testInsertProduct() started");
		ProductService ps = new ProductService();
		boolean expectedOutput = true;
		boolean obtainedOutput = ps.insertProduct(new Product(5,"Egg"));
//		if(expectedOutput && obtainedOutput)
//			logger.info("testInsertProduct() success");//System.out.println("testInsertProduct() success");
//		else
//			fail("testInsertProduct()");
		Assert.assertEquals(obtainedOutput,expectedOutput);
		logger.info("testInsertProduct() finished");
	}


}
