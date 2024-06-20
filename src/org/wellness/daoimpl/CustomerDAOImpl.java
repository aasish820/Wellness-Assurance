package org.wellness.daoimpl;

import java.util.ArrayList;
import java.util.Scanner;

import org.wellness.dao.CustomerDAO;
import org.wellness.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	ArrayList addCustomer = new ArrayList();
	
	@Override
	public void registerCustomer() {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Enter Customer ID: ");
	String customer_id = sc.next();
	
	
	}


}
