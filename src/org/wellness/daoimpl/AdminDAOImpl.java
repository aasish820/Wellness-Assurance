package org.wellness.daoimpl;

import java.util.ArrayList;
import java.util.Scanner;

import org.wellness.dao.AdminDAO;
import org.wellness.model.Admin;

public class AdminDAOImpl implements AdminDAO {
	ArrayList<Admin> addAdmin = new ArrayList<Admin>();

	@Override
	public void registerAdmin() {
		Scanner sc = new Scanner(System.in);

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
		
		
	
}
