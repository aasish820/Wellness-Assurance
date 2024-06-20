package org.wellness.client;

import java.util.Scanner;

import org.wellness.daoimpl.AdminDAOImpl;
import org.wellness.daoimpl.CategoryDAOImpl;
import org.wellness.daoimpl.CustomerDAOImpl;
import org.wellness.daoimpl.PolicyDAOImpl;
import org.wellness.daoimpl.SubcategoryDAOImpl;

public class WellnessAssurance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdminDAOImpl admindaoimpl = new AdminDAOImpl();
		CustomerDAOImpl customerdaoimpl = new CustomerDAOImpl();
//		CategoryDAOImpl categorydaoimpl = new CategoryDAOImpl();
//		SubcategoryDAOImpl subcategorydaoimpl = new SubcategoryDAOImpl();
//		PolicyDAOImpl policydaoimpl = new PolicyDAOImpl();

		while (true) {
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			System.out.println("XX      1.LOGIN                 XX");
			System.out.println("XX      2.REGISTER              XX");
			System.out.println("XX      3.FORGOT PASSWORD       XX");
			System.out.println("XX      4.EXIT                  XX");
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

			// Getting option from user
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
			System.out.println();
			switch (choice) {
			case 1:
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
				System.out.println("XX      1.Customer              XX");
				System.out.println("XX      2.Admin                 XX");
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
				System.out.print("Enter your choice: ");
				int login_choice = sc.nextInt();
				sc.nextLine();
				System.out.println();

				switch (login_choice) {
					case 1:
						System.out.println("Enter Your User Name: ");
						String customerUsername = sc.nextLine();
	
						System.out.println("Enter your password: ");
						String customerPassword = sc.nextLine();
						boolean checkDetails = customerdaoimpl.customerLogin(customerUsername, customerPassword);
						if (checkDetails == true) {
							System.out.println("Customer Login Successful");
							
							// After customer logs in
							 customer_loop: while(true) {
								System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
								System.out.println("XX      1.Apply For Policy      XX");
								System.out.println("XX      2.Edit My Information   XX");
								System.out.println("XX      3.View My Policy        XX");
								System.out.println("XX      4.Logout                XX");
								System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
								System.out.print("Enter your choice: ");
								int customer_choice = sc.nextInt();
								sc.nextLine();
								System.out.println();
								
								// Customer choices
								switch(customer_choice) {
								case 1:
									break;
								case 2:
									break;
								case 3:
									break;
									
									// LOGOUT
								case 4:
									break customer_loop;
										
								}
							}
						} else {
							System.out.println("Customer Login Failed. Please Try Again.");
						}
						break;

					case 2:
						System.out.println("Enter Your User Name");
						String username = sc.nextLine();
						System.out.println("Enter your password");
						String password = sc.nextLine();
	
						break;

				}

				break;
			case 2:

				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
				System.out.println("XX      1.Customer              XX");
				System.out.println("XX      2.Admin                 XX");
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
				System.out.print("Enter your choice: ");
				int reg_choice = sc.nextInt();
				sc.nextLine();
				System.out.println();

				switch (reg_choice) {
				case 1:
					// Register Customer
					customerdaoimpl.registerCustomer();
					break;

				case 2:
					// Admin Register
					admindaoimpl.registerAdmin();
					break;
				}
				break;
				
			// Forget Password
			case 3:
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
				System.out.println("XX      1.Customer              XX");
				System.out.println("XX      2.Admin                 XX");
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
				System.out.print("Enter your choice: ");
				int for_choice = sc.nextInt();
				sc.nextLine();
				System.out.println();
				switch(for_choice) {
					// customer forgot password
					case 1:
						System.out.println("Enter your username: ");
						String for_cus_username = sc.nextLine();
						customerdaoimpl.CustomerPasswordReset(for_cus_username);
						break;
						
					// admin forgot password
					case 2:
						System.out.println("Enter your username: ");
						String for_admin_username = sc.nextLine();
						admindaoimpl.AdminPasswordReset(for_admin_username);
						break;
				}
				
				
				break;

			case 4:
				System.exit(0);
			}
		}
	}
}
