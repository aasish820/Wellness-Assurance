package org.wellness.daoimpl;

import java.util.ArrayList;
import java.util.Scanner;

import org.wellness.dao.CustomerDAO;
import org.wellness.model.Customer;
import org.wellness.model.Policy;

public class CustomerDAOImpl implements CustomerDAO {
	Scanner sc = new Scanner(System.in);
	ArrayList<Customer> addCustomer = new ArrayList<Customer>();
	
	@Override
	public ArrayList<Customer> getAllCustomer() {
		return addCustomer;
	}

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
		
		ArrayList<String> validate = validateCustomer(customer);
		if (validate.size() < 1) {
			boolean result = addCustomer.add(customer);

			if (result == true) {

				System.out.println("New Customer Registered Successfully");
			} else {

				System.out.println("Customer Registration Failed. Please Try Again");
			}
		} else {
			System.out.println("Registration failed");
			for(int i = 0; i < validate.size(); i++) {
				System.out.println("!!!!!   " + validate.get(i) + "   !!!!!!");
			}
			registerCustomer();
		}
	}

	private ArrayList<String> validateCustomer(Customer customer) {
		ArrayList<String> msg = new ArrayList<String>();
		if(customer.getAge() < 16 || customer.getAge() > 80) {
			msg.add("Age must be between 16 and 80");
		}
		
		if(customer.getFullName().length() < 1) {
			msg.add("Name cannot be empty");
		}
		return msg;
	}

	@Override
	public boolean customerLogin(String username, String password) {
		for (int i = 0; i < addCustomer.size(); i++) {

			Customer storedCustDetails = addCustomer.get(i);

			if (storedCustDetails.getUsername().equals(username) && storedCustDetails.getPassword().equals(password)) {
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

	public ArrayList<Customer> getPendingList() {
		// TODO Auto-generated method stub
		ArrayList<Customer> pendinglist = new ArrayList<Customer>();
		for (int i = 0; i < addCustomer.size(); i++) {
			Customer storedCustDetails = addCustomer.get(i);
			if (storedCustDetails.isApplied() == true && storedCustDetails.isAccepted() == false) {
				pendinglist.add(addCustomer.get(i));
			}
		}
		return pendinglist;
	}

	@Override
	public void applyPolicy(Policy policy, Customer customer) {
		customer.setApplied(true);
		customer.setPolicy_id(policy.getPolicy_id());
		System.out.println("Application has been submitted");
	}

	@Override
	public Customer getCustomerByCredentials(String customerUsername, String customerPassword) {

		for (int i = 0; i < addCustomer.size(); i++) {

			Customer storedCustDetails = addCustomer.get(i);

			if (storedCustDetails.getUsername().equals(customerUsername)
					&& storedCustDetails.getPassword().equals(customerPassword)) {
				return storedCustDetails;
			}

		}
		return null;

	}

	@Override
	public void updateCustomer(Customer customer) {
		updateloop: while (true) {
			System.out.println("What do you want to edit?");
			System.out.println("1. Name");
			System.out.println("2. Address");
			System.out.println("3. Age");
			System.out.println("4. Phone Number");
			System.out.println("5. Email");
			System.out.println("6. Cancel");
			System.out.println();
			System.out.println("Choose an option: ");
			int option = sc.nextInt();
			sc.nextLine();
			switch (option) {
			case 1:
				System.out.println("Enter new name: ");
				String name = sc.nextLine();
				customer.setFullName(name);
				System.out.println("Name has been updated");
				break;
			case 2:
				System.out.println("Enter new address: ");
				String address = sc.nextLine();
				customer.setAddress(address);
				System.out.println("Address has been updated");
				break;
			case 3:
				System.out.println("Enter new age: ");
				int age = sc.nextInt();
				sc.nextLine();
				customer.setAge(age);
				System.out.println("Name has been updated");
				break;
			case 4:
				System.out.println("Enter new phone number: ");
				String phone = sc.nextLine();
				customer.setPh_num(phone);
				System.out.println("Phone has been updated");
				break;
			case 5:
				System.out.println("Enter new email: ");
				String email = sc.nextLine();
				customer.setFullName(email);
				System.out.println("Email has been updated");
				break;
			case 6:
				break updateloop;
			default:
				System.out.println("Invalid option");
				break;
			}
		}		
	}

	@Override
	public void cancelRequest(Customer customer) {
		customer.setCancel(true);
		System.out.println("Cancel request has been sent");
	}
	
	@Override
	public ArrayList<Customer> getCancelRequests() {
		ArrayList<Customer> pendinglist = new ArrayList<Customer>();
		for (int i = 0; i < addCustomer.size(); i++) {
			Customer storedCustDetails = addCustomer.get(i);
			if (storedCustDetails.isCancel() == true) {
				pendinglist.add(addCustomer.get(i));
			}
		}
		return pendinglist;
	}


}
