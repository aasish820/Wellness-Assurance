package org.wellness.daoimpl;

import java.util.ArrayList;
import java.util.Scanner;

import org.wellness.dao.CustomerDAO;
import org.wellness.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	Scanner sc = new Scanner(System.in);
	ArrayList<Customer> addCustomer = new ArrayList<Customer>();

	@Override
	public void registerCustomer() {

		System.out.println("Enter Customer ID: ");
		String customer_id = sc.nextLine();

		System.out.println("Enter Fullname: ");
		String fullName = sc.nextLine();

		System.out.println("Enter Address: ");
		String address = sc.nextLine();

		System.out.println("Enter Age: ");
		int age = sc.nextInt();
		sc.nextLine();

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
		} else {

			System.out.println("Customer Registration Failed. Please Try Again");
		}

	}

	@Override
	public boolean customerLogin(String username, String password) {
		for(int i=0; i < addCustomer.size(); i++) {
			
			Customer storedCustDetails = addCustomer.get(i);
			
			if(storedCustDetails.getUsername().equals(username)&&storedCustDetails.getPassword().equals(password)) {
				return true;
			}
			
		}
		return false;
		
	}
	
	@Override
	public void CustomerPasswordReset(String username) {
		for (int i = 0; i < addCustomer.size(); i++) {
			Customer storedCustDetails = addCustomer.get(i);
			if (storedCustDetails.getUsername().equals(username)) {
				System.out.println("Enter new password: ");
				String password = sc.nextLine();
				storedCustDetails.setPassword(password);
				System.out.println("Password Changed Successfully");
				return;
			}
		}
		System.out.println("Password could not be changed. Please try again!!");	
	}
}
