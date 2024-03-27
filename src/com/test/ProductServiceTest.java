package com.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.exception.InventoryDetailsNotFound;
import com.model.Inventory;
import com.model.Product;
import com.service.ProductService;

public class ProductServiceTest {
	ProductService productService = new ProductService();

	/********************************************************************************/
	@Test
	public void getProductDetails() {
		List<Product> expectedOutput = new ArrayList<Product>();
		Product p1 = new Product(1, "mobile", "fresh product", 50000);
		Product p2 = new Product(2, "Smartphone", "A high-quality smartphone with an excellent camera",999);
		Product p3 = new Product(3, "Laptop", "Lightweight and powerful, perfect for professionals on the go",1299);
		Product p4 = new Product(4, "Headphones", "Noise-cancelling headphones with superb sound quality",299);
		Product p5 = new Product(5, "Smartwatch", "Keep track of your fitness and notifications",199);
		Product p6 = new Product(6, "Tablet", "A versatile tablet for work, play, and everything in between",499);
		Product p7 = new Product(7,"E-reader","Carry thousands of books in one convenient device",129);
		Product p8 = new Product(8,"Portable Speaker","High-quality sound on the go",79);
		Product p9 = new Product(9,"Gaming Console","The latest gaming console for the ultimate gaming experience",499);
		Product p10 =new Product(10,"Wireless Mouse","Ergonomic design for comfortable use",49);
		Product p11 =new Product(11,"Webcam","High-definition webcam for clear video calls",89);
		expectedOutput.add(p1);
		expectedOutput.add(p2);
		expectedOutput.add(p3);
		expectedOutput.add(p4);
		expectedOutput.add(p5);
		expectedOutput.add(p6);
		expectedOutput.add(p7);
		expectedOutput.add(p8);
		expectedOutput.add(p9);
		expectedOutput.add(p10);
		expectedOutput.add(p11);
		
		try {
			Assert.assertEquals(expectedOutput, productService.getProductDetails());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/********************************************************************************/

	@Test
	public void checkAvailability() {
		// Use Case "Valid Credentials"
		int pid = 1;
		Inventory i = new Inventory();
		i.setProductId(1);
		i.setQuantityInStock(100);
		boolean expectedOutput = true;
		Assert.assertEquals(expectedOutput, productService.checkAvailability(i, pid));
		// Use Case "invalid credentials"
		i.setProductId(1);
		i.setQuantityInStock(0);
		expectedOutput = false;
		Assert.assertEquals(expectedOutput, productService.checkAvailability(i, pid));
	}

	/********************************************************************************/
	@Test
	public void getInventoryDetails() {
		// Use Case "Valid Credentials"
		int id = 1;
		Inventory expectedOutput = new Inventory();
		expectedOutput.setProductId(1);
		expectedOutput.setQuantityInStock(34);
		try {
			Assert.assertEquals(expectedOutput, productService.getInventoryDetails(id));
		} catch (SQLException | InventoryDetailsNotFound e) {
		}

		// Use Case "Invalid credentials"
		id = 50;
		try {
			Assert.assertEquals(expectedOutput, productService.getInventoryDetails(id));
		} catch (SQLException | InventoryDetailsNotFound e) {
			Assert.assertEquals("Item out of stock".toLowerCase(), e.getMessage().toLowerCase());

		}
	}

	/********************************************************************************/

}
