package com.controller;
import java.sql.SQLException;
import com.exception.CustomerNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import com.service.*;
import com.model.*;
public class CustomerController {
public static void main(String[] args) {
	CustomerService customerservice=new CustomerService();
	Scanner sc=new Scanner(System.in);
	
	
	while (true) {
		System.out.println("*****************CUSTOMER OPS ****************");
		System.out.println("Enter 1 for calculating total orders");
		System.out.println("Enter 2 for get customer Details");
		System.out.println("Enter 3 for update customer details");
		System.out.println("Enter 0 for exit");
		System.out.println("********************************************");
		int input = sc.nextInt();
		if (input == 0) {
			System.out.println("Thank you!!");
			break;
		}
		switch(input) {
		case 1:
			System.out.println("Enter the customer id");
			int cid=sc.nextInt();
			List<Order>list1=new ArrayList<>();
			try {
				customerservice.validateCustomer(cid);
				list1 = customerservice.calculateTotalOrders(cid);
				System.out.println("Number of orders placed by Customer ID-" + cid + " was " + list1.size());
			}
			catch (SQLException | CustomerNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
			
		case 2:
			List<Customer>list=new ArrayList<>();
			try {
				list=customerservice.getCustomerDetails();
				for(Customer c:list) {
					System.out.println(c);
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			break;
		case 3:
			System.out.println("Enter customer id");
	    	int id=sc.nextInt();
	    	sc.nextLine();
			System.out.println("Enter email");
	    	String email=sc.nextLine();
	    	
	    	System.out.println("Enter phone number");
	    	String phone=sc.nextLine();
	    	System.out.println("Enter address");
	    	String address=sc.nextLine();
	    	try {
	    	customerservice.updateCustomer(id, email, phone, address);
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
