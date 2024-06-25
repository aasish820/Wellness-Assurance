package org.wellness.dao;

import java.util.ArrayList;

import org.wellness.model.Customer;
import org.wellness.model.Policy;

public interface CustomerDAO {
	ArrayList<Customer> getAllCustomer(); 
	void registerCustomer();
	boolean customerLogin(String username, String password);
	void CustomerPasswordReset(String for_cus_username);
	void acceptApplication(Customer customer);
	void applyPolicy(Policy policy, Customer customer);
	Customer getCustomerByCredentials(String customerUsername, String customerPassword);
	void updateCustomer(Customer customer);
}
