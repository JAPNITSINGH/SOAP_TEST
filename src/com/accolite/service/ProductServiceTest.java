package com.accolite.service;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;



class ProductServiceTest {
	static Logger logger = Logger.getLogger(ProductServiceTest.class.getName());
	private List<Product> listOfProducts = new ArrayList<Product>();
	//List<Product> p = new ArrayList<Product>;
	 
 	void init()
 	{	listOfProducts.clear();
 		listOfProducts.add(new Product(1, "Apple"));
		listOfProducts.add(new Product(2, "Banana"));
		listOfProducts.add(new Product(3, "Carrot"));
		listOfProducts.add(new Product(4, "Drum Sticks"));
		//logger.info("inti() successful"); 
 	}

	@Test
	void testSearchByID() {
		ProductService ps = new ProductService();
		Product expectedOutput = new Product(1, "Apple");
		Product obtainedOutput = ps.searchByID(1);
//		if(expectedOutput.getId() == obtainedOutput.getId())
//			logger.info("testSearchByID() success");//System.out.println("testSearchByID() success");
//		else
//			fail("testSearchByID() failed");
		//assert expectedOutput.getId() == 2 : "testSearchByID() failed";
		 assertTrue(obtainedOutput.getId() == expectedOutput.getId());
		logger.info("testSearchByID() success");
	}

	@Test
	void testGetAllProducts() {
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
		
	}

	@Test
	void testDeleteProduct() {
		init();
		ProductService ps = new ProductService();
		boolean expectedOutput = true;
		Product p = new Product(1,"Apple");
		boolean obtainedOutput = ps.deleteProduct(p);
//		if(expectedOutput && obtainedOutput)
//			logger.info("testDeleteProduct() success");//System.out.println("testDeleteProduct() Success");
//		else
//			fail("testDeleteProduct() failed");
		assertTrue(obtainedOutput == expectedOutput);
		logger.info("testDeleteProduct() success");
	}


	@Test
	void testInsertProduct() {
		ProductService ps = new ProductService();
		boolean expectedOutput = true;
		boolean obtainedOutput = ps.insertProduct(new Product(5,"Egg"));
//		if(expectedOutput && obtainedOutput)
//			logger.info("testInsertProduct() success");//System.out.println("testInsertProduct() success");
//		else
//			fail("testInsertProduct()");
		assertTrue(obtainedOutput == expectedOutput);
		logger.info("testInsertProduct() success");
	}


}
