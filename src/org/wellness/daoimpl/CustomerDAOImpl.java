package org.wellness.daoimpl;

import java.util.ArrayList;
import java.util.Scanner;

import org.wellness.dao.CustomerDAO;
import org.wellness.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	ArrayList<Customer> addCustomer = new ArrayList<Customer>();
	
	@Override
	public void registerCustomer() {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter Customer ID: ");
	String customer_id = sc.nextLine();
	
	System.out.println("Enter Fullname: ");
	String fullName = sc.nextLine();
	
	System.out.println("Enter Address: ");
	String address = sc.nextLine();
	
	System.out.println("Enter Age: ");
	int age = sc.nextInt();
	
	System.out.println("Enter Phone Number: ");
	String ph_num = sc.nextLine();
	
	System.out.println("Enter Username: ");
	String username = sc.nextLine();
	
	System.out.println("Enter Password: ");
	String password = sc.nextLine();
	
	System.out.println("Enter Email: ");
	String email = sc.nextLine();
	
	
	Customer customer = new Customer(customer_id, fullName, address, age, ph_num, username, password, email);
	
	boolean result = addCustomer.add(customer);
	
	if (result == true) {
		
		System.out.println("New Customer Registered Successfully");
	}else {
		
		System.out.println("Customer Registration Failed. Please Try Again");
	}
	
	for(int i=0; i<addCustomer.size();i++) {
		
		System.out.println(addCustomer.get(i).getFullName());
	}
	
	
	}


}
