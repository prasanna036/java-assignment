package com.controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import com.service.*;
import com.util.DBUtil;
import com.model.*;
public class OrderDetailController {
	public static void main(String[] args) throws SQLException {
		OrderDetailService orderservice=new OrderDetailService();
		Scanner sc=new Scanner(System.in);
		
		
		while (true) {
			System.out.println("*****************ORDER DETAIL OPS ****************");
			System.out.println("Enter 1 for to calculate sub total");
			System.out.println("Enter 2 for get order Details info");
			System.out.println("Enter 3 for update quantity");
			System.out.println("Enter 0 for exit");
			System.out.println("********************************************");
			int input = sc.nextInt();
			if (input == 0) {
				System.out.println("Thank you!!");
				break;
			}
			switch(input) {
			case 1:
				System.out.println("Enter the Customer id");
				int id=sc.nextInt();
				int u=orderservice.calculateSubTotal(id);
				System.out.println("Sub Total:"+u);
				break;
				
			case 2:
				List<OrderDetail>list=new ArrayList<>();
				try {
					list=orderservice.getOrderDetailsInfo();
					for(OrderDetail o:list) {
						System.out.println(o);
					}
					
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				break;
				
			case 3:
				System.out.println("Enter order detail id");
		    	id=sc.nextInt();
				System.out.println("Enter the quantity");
		    	int quantity=sc.nextInt();
		    	
		    	System.out.println("Enter the orders_id");
		    	int orders_id=sc.nextInt();
		    	System.out.println("Enter product_id");
		    	int product_id=sc.nextInt();
		    	try {
		    	orderservice.updateOrder(id,quantity,orders_id,product_id);
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

	

