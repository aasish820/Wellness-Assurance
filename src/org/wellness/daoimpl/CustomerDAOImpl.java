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
	String customer_id = sc.next();
	
	System.out.println("Enter Fullname: ");
	String fullName = sc.next();
	
	System.out.println("Enter Address: ");
	String address = sc.next();
	
	System.out.println("Enter Age: ");
	int age = sc.nextInt();
	
	System.out.println("Enter Phone Number: ");
	String ph_num = sc.next();
	
	System.out.println("Enter Username: ");
	String username = sc.next();
	
	System.out.println("Enter Password: ");
	String password = sc.next();
	
	System.out.println("Enter Email: ");
	String email = sc.next();
	
	
	Customer customer = new Customer(customer_id, fullName, address, age, ph_num, username, password, email);
	
	addCustomer.add(customer);
	
	for(int i=0; i<addCustomer.size();i++) {
		
		System.out.println(addCustomer.get(i).getFullName());
	}
	
	
	}


}
