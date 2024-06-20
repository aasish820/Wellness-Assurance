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
		System.out.println("Enter ph_num: ");
		String ph_num = sc.nextLine();
		System.out.println("Enter Username: ");
		String username = sc.nextLine();
		System.out.println("Enter Password: ");
		String password = sc.nextLine();
		System.out.println("Enter email: ");
		String email = sc.nextLine();

		Admin admin = new Admin(admin_id, name, address, ph_num, username, password, email);
		boolean result = addAdmin.add(admin);
		if (result == true) {
			System.out.println("Admin register successfully");
		} else {
			System.out.println("Admin couldn't register. Please try again");
		}

	}

	@Override
	public boolean adminLogin(String username, String password) {
		for(int i=0; i<addAdmin.size(); i++){
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
}
