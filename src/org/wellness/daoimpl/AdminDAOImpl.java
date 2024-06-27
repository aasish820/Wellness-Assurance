package org.wellness.daoimpl;

import java.util.ArrayList;
import java.util.Scanner;

import org.wellness.dao.AdminDAO;
import org.wellness.model.Admin;
import org.wellness.model.Customer;

public class AdminDAOImpl implements AdminDAO {

	Scanner sc = new Scanner(System.in);
	ArrayList<Admin> addAdmin = new ArrayList<Admin>();

	@Override
	public void registerAdmin() {
		System.out.println("Enter Admin ID: ");
		String admin_id = sc.nextLine();

		System.out.println("Enter Admin Name: ");
		String name = sc.nextLine();

		System.out.println("Enter address: ");
		String address = sc.nextLine();

//		System.out.println("Enter ph_num: ");
//		String ph_num = sc.nextLine();
		String ph_num = "";
		boolean validPhone = false;
		String phoneRegex = "\\d{10}"; // Regular expression for exactly 10 digits

		while (!validPhone) {
			System.out.println("Enter Phone Number: ");
			ph_num = sc.nextLine();

			if (ph_num.matches(phoneRegex)) {
				validPhone = true;
			} else {
				System.out.println("Phone number must be exactly 10 digits. Please enter a valid phone number.");
			}
		}

		System.out.println("Enter Username: ");
		String username = sc.nextLine();

		System.out.println("Enter Password: ");
		String password = sc.nextLine();

//		System.out.println("Enter email: ");
//		String email = sc.nextLine();
		String email = "";
		boolean validEmail = false;
		String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$"; // Regular expression for email format

		while (!validEmail) {
			System.out.println("Enter Email: ");
			email = sc.nextLine();

			if (email.matches(emailRegex)) {
				validEmail = true;
			} else {
				System.out.println("Email format is invalid. Please enter a valid email.");
			}
		}

		Admin admin = new Admin(admin_id, name, address, ph_num, username, password, email);
		ArrayList<String> validate = validateAdmin(admin);
		if (validate.size() < 1) {
			boolean result = addAdmin.add(admin);

			if (result == true) {

				System.out.println("New Admin Registered Successfully");
			} else {

				System.out.println("Admin Registration Failed. Please Try Again");
			}
		} else {
			System.out.println("Registration failed");
			for (int i = 0; i < validate.size(); i++) {
				System.out.println("!!!!!   " + validate.get(i) + "   !!!!!!");
			}
			registerAdmin();
		}

	}

	@Override
	public boolean adminLogin(String username, String password) {
		for (int i = 0; i < addAdmin.size(); i++) {
			if (addAdmin.get(i).getUsername().equals(username) && addAdmin.get(i).getPassword().equals(password)) {
				return true; // Username and password match
			}
		}
		return false; // No match found
	}

	@Override
	public void AdminPasswordReset(String username) {
		for (int i = 0; i < addAdmin.size(); i++) {
			Admin storedAdminDetails = addAdmin.get(i);
			if (storedAdminDetails.getUsername().equals(username)) {
				System.out.println("Enter new password: ");
				String password = sc.nextLine();
				storedAdminDetails.setPassword(password);
				System.out.println("Password Changed Successfully");
				return;
			}
		}
		System.out.println("Password could not be changed. Please try again!!");
	}

	private ArrayList<String> validateAdmin(Admin admin) {
		ArrayList<String> msg = new ArrayList<String>();

		if (admin.getAdmin_id().length() < 1 || admin.getAdmin_id().length() > 10) {
			msg.add("Admin ID has to be between 1 and 10 characters");
		}

		if (admin.getFullName().length() < 1) {
			msg.add("Name cannot be empty");
		}

		if (admin.getAddress().length() < 1) {
			msg.add("Address is required");
		}

		if (admin.getPh_num().length() < 1) {
			msg.add("Phone number cannot be empty");
		}

		if (admin.getUsername().length() < 1) {
			msg.add("Username cannot be empty");
		}

		if (admin.getPassword().length() < 1 || admin.getPassword().length() < 8) {
			msg.add("Password has to be at least 8 characters");
		}

		if (admin.getEmail().length() < 1) {
			msg.add("Email cannot be empty");
		}
		return msg;
	}

	@Override
	public void acceptApplication(Customer customer) {
		customer.setAccepted(true);
		System.out.println("Application has been accepted");
		// TODO Auto-generated method stub

	}

	@Override
	public void adminCancelRequest(Customer customer) {
		customer.setPolicy_id(null);
		customer.setCancel(false);
		customer.setAccepted(false);
		customer.setApplied(false);
		System.out.println("Policy cancel request accepted");
	}
}
