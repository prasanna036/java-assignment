package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import com.service.*;
import com.util.DBUtil;
import com.model.*;
public class OrdersController {
public static void main(String[] args) {
	OrdersService orderservice=new OrdersService();
	Scanner sc=new Scanner(System.in);
	
	
	while (true) {
		System.out.println("*****************ORDERS OPS ****************");
		System.out.println("Enter 1 for to calculate total amount");
		System.out.println("Enter 2 for get order Details");
		System.out.println("Enter 3 for update order details");
		System.out.println("Enter 4 for to cancel order");
		System.out.println("Enter 0 for exit");
		System.out.println("********************************************");
		int input = sc.nextInt();
		if (input == 0) {
			System.out.println("Thank you!!");
			break;
		}
		switch(input) {
		case 1:
			
			break;
			
		case 2:
			List<Order>list=new ArrayList<>();
			try {
				list=orderservice.getOrderDetails();
				for(Order o:list) {
					System.out.println(o);
				}
				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			break;
		case 3:
			System.out.println("Enter order id");
	    	int id=sc.nextInt();
	    	sc.nextLine();
			System.out.println("Enter order date");
	    	String order_date=sc.nextLine();
	    	
	    	System.out.println("Enter the total amount");
	    	int total_amount=sc.nextInt();
	    	System.out.println("Enter customer_id");
	    	int customer_id=sc.nextInt();
	    	try {
	    	orderservice.updateOrder(id, order_date, total_amount, customer_id);
	    	System.out.println("Record updated");
	    	}
	    	catch(SQLException e) {
	    		e.printStackTrace();
	    	}
			break;
		case 4:
			System.out.println("Enter customer id");
	    	id=sc.nextInt();
	    	try {
		    	orderservice.cancelOrder(id);
		    	System.out.println("Order Cancelled");
		    	}
		    	catch(SQLException e) {
		    		e.printStackTrace();
		    	}
			break;

		}
	}
}
}
