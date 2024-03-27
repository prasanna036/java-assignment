package com.controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import com.service.*;
import com.exception.InventoryDetailsNotFound;
import com.model.*;
import com.util.*;
public class ProductController {

	public static void main(String[] args) {
		ProductService productservice=new ProductService();
		Scanner sc=new Scanner(System.in);
		
		
		while (true) {
			System.out.println("*****************PRODUCT OPS ****************");
			System.out.println("Enter 1 for to check product in stock");
			System.out.println("Enter 2 for get product Details");
			System.out.println("Enter 3 for update product details");
			System.out.println("Enter 0 for exit");
			System.out.println("********************************************");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Thank you!!");
				break;
			}
			switch(input) {
			case 1:
				System.out.println("Enter the Product ID to check product in stock");
				int pid1 = sc.nextInt();
				try {
					Inventory i=productservice.getInventoryDetails(pid1);
					boolean productAvailable=productservice.checkAvailability(i,pid1);
					if(!productAvailable) {
						System.out.println("Product not in Stock Check after sometime");
					}
					else {
						System.out.println("Product in stock you can Order");
					}
				} catch (SQLException | InventoryDetailsNotFound e) {
					System.out.println(e.getMessage());
				}

				break;
				
			case 2:
				List<Product>list=new ArrayList<>();
				try {
					list=productservice.getProductDetails();
					for(Product p:list) {
						System.out.println(p.getId()+"  "+p.getName()+"    "+p.getDescription()+"  "+p.getPrice());

					}
					
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				
				break;
			case 3:
				System.out.println("Enter product id");
		    	int id=sc.nextInt();
		    	sc.nextLine();
				System.out.println("Enter name");
		    	String name=sc.nextLine();
		    	
		    	System.out.println("Enter description");
		    	String description=sc.nextLine();
		    	System.out.println("Enter price");
		    	int price=sc.nextInt();
		    	try {
		    	productservice.updateProduct(id, name, description, price);
		    	System.out.println("Record updated");
		    	}
		    	catch(SQLException e) {
		    		e.printStackTrace();
		    	}
				break;
			
			}

	}
	}
}
