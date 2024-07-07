package org.wellness.client;

import java.util.ArrayList;
import java.util.Scanner;

import org.wellness.daoimpl.AdminDAOImpl;
import org.wellness.daoimpl.CategoryDAOImpl;
import org.wellness.daoimpl.CustomerDAOImpl;
import org.wellness.daoimpl.PolicyDAOImpl;
import org.wellness.daoimpl.SubcategoryDAOImpl;
import org.wellness.model.Category;
import org.wellness.model.Customer;
import org.wellness.model.Policy;
import org.wellness.model.Subcategory;

public class WellnessAssurance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdminDAOImpl admindaoimpl = new AdminDAOImpl();
		CustomerDAOImpl customerdaoimpl = new CustomerDAOImpl();
		CategoryDAOImpl categorydaoimpl = new CategoryDAOImpl();
		SubcategoryDAOImpl subcategorydaoimpl = new SubcategoryDAOImpl();
		PolicyDAOImpl policydaoimpl = new PolicyDAOImpl();

		while (true) {
			// Starting view
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
				// Login View
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
					// Customer Login
					System.out.println("Enter Your User Name: ");
					String customerUsername = sc.nextLine();
					System.out.println("Enter your password: ");
					String customerPassword = sc.nextLine();
					boolean checkDetails = customerdaoimpl.customerLogin(customerUsername, customerPassword);
					Customer customer = customerdaoimpl.getCustomerByCredentials(customerUsername, customerPassword);
					if (checkDetails == true) {
						System.out.println("Customer Login Successful");
						// After customer logs in
						customer_loop: while (true) {
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
							switch (customer_choice) {
							case 1:
								// 1. Apply for policy
								ArrayList<Category> category_list = categorydaoimpl.getAllCategories();
								if (category_list.size() < 1) {
									System.out.println("Category has not been added");
								} else {
									for (int i = 0; i < category_list.size(); i++) {
										System.out.println((i + 1) + ")" + category_list.get(i).getInc_type());
									}
									System.out.println("Choose a category: ");
									int apply_category_option = sc.nextInt();
									sc.nextLine();

									String apply_category_id = category_list.get(apply_category_option - 1)
											.getCategory_id();
									ArrayList<Subcategory> sub_category_list = subcategorydaoimpl
											.getSubCategoriesByCategoryID(apply_category_id);
									if (sub_category_list.size() < 1) {
										System.out.println("Sub Category has not been added");
										break;
									} else {
										for (int i = 0; i < sub_category_list.size(); i++) {
											System.out.println(
													(i + 1) + ")" + sub_category_list.get(i).getSub_Catogory_type());
										}
										System.out.println("Choose a sub category: ");
										int apply_sub_category_option = sc.nextInt();
										sc.nextLine();

										String apply_sub_category_id = sub_category_list.get(apply_sub_category_option - 1)
												.getSub_catogory_id();
										ArrayList<Policy> policy_list = policydaoimpl
												.getPolicyBySubCategoryID(apply_sub_category_id);
										if (policy_list.size() < 1) {
											System.out.println("Policy has not been added");
											break;
										} else {
											for (int i = 0; i < policy_list.size(); i++) {
												System.out.println((i + 1) + ")" + policy_list.get(i).getPlan_type());
												System.out.println(
														"Monthly Premium: " + policy_list.get(i).getMonthly_premium());
												System.out.println("Coverage: " + policy_list.get(i).getCoverage());
												System.out.println("Deductable: " + policy_list.get(i).getDeductable());
												System.out.println();
											}
											System.out.println("Choose a policy: ");
											int apply_policy_option = sc.nextInt();
											sc.nextLine();
											
											if(apply_policy_option > policy_list.size()) {
												break;
											}

											Policy apply_policy = policy_list.get(apply_policy_option - 1);
											customerdaoimpl.applyPolicy(apply_policy, customer);
										}
									}
								}
								break;
							case 2:
								// 2) Edit my information
								customerdaoimpl.updateCustomer(customer);
								break;
							case 3:
								// 3. View my policy
								Policy my_policy = policydaoimpl.getPolicyByID(customer.getPolicy_id());

								if (my_policy != null) {
									Subcategory my_subcategory = subcategorydaoimpl
											.getSubCategoriesByID(my_policy.getSub_category_id());

									Category my_category = categorydaoimpl
											.getCategoriesByID(my_subcategory.getCatogory_id());
									
									String applied = "No", accepted = "No";
									if (customer.isApplied() == true) {
										applied = "Yes";
										if (customer.isAccepted() == true) {
											accepted = "Yes";
										}
									}

									System.out.println("Category: " + my_category.getInc_type() + "\t"
											+ "Sub Category: " + my_subcategory.getSub_Catogory_type() + "\t"
											+ "Policy: " + my_policy.getPlan_type() + "\t" + "Monthly Premium: "
											+ my_policy.getMonthly_premium() + "\t" + "Coverage: "
											+ my_policy.getCoverage() + "\t" + "Deductable: "
											+ my_policy.getDeductable() + "\t" + "Applied: " + applied + "\t"
											+ "Accepted: " + accepted);

								}
								
								System.out.println();
								System.out.println("1. Cancel Policy");
								System.out.println("2. Back to Dashboard");
								System.out.println();
								System.out.println("Enter your choice: ");
								int cust_policy_choice = sc.nextInt();
								sc.nextLine();
								
								switch (cust_policy_choice) {
									case 1:
										// Cancel policy application
										customerdaoimpl.cancelRequest(customer);
										break;
										
									case 2:
										// Go back to dashboard
										break;
										
									default:
										System.out.println("Invalid option");
										break;
								}
								break;

							// LOGOUT
							case 4:
								break customer_loop;

							default:
								System.out.println("Invalid option");
								break;
							}
						}
					} else {
						System.out.println("Customer Login Failed. Please Try Again.");
					}
					break;

				case 2:
					// Admin Login
					System.out.println("Enter Your User Name");
					String username = sc.nextLine();
					System.out.println("Enter your password");
					String password = sc.nextLine();
					boolean admin_check = admindaoimpl.adminLogin(username, password);
					if (admin_check == true) {
						System.out.println("Admin login Scucessfully");
						admin_loop: while (true) {
							System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
							System.out.println("XX      1.ADD Category          XX");
							System.out.println("XX      2.Category Operations   XX");
							System.out.println("XX      3.Customer Operations   XX");
							System.out.println("XX      4.Pending Policy        XX");
							System.out.println("XX      5.Policy Cancel Request XX");
							System.out.println("XX      6.Logout                XX");
							System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
							System.out.print("Enter your choice: ");
							int admin_choice = sc.nextInt();
							sc.nextLine();
							System.out.println();
							switch (admin_choice) {
							case 1:
								// Add Category
								while (true) {
									categorydaoimpl.addCategory();
									// Getting all the subcategories based on category
									Category last_category_obj = categorydaoimpl.getAllCategories()
											.get(categorydaoimpl.getAllCategories().size() - 1);
									while (true) {
										// Adding sub category
										String sub_id = subcategorydaoimpl
												.addSubcategory(last_category_obj.getCategory_id());
										Subcategory last_subcategory_obj = subcategorydaoimpl.getAllSubCategories().get(subcategorydaoimpl.getAllSubCategories().size() - 1);

										while (true) {
											// Add Policy
											policydaoimpl.addPolicy(sub_id);
											System.out.println("Do you want to add more Policy for " + last_subcategory_obj.getSub_Catogory_type() + "? (y/n)");
											String policy_option = sc.nextLine();
											if (policy_option.toLowerCase().equals("n"))
												break;
										}

										System.out.println("Do you want to add more Sub categories for " + last_category_obj.getInc_type() + "? (y/n)");
										String sub_option = sc.nextLine();
										if (sub_option.toLowerCase().equals("n"))
											break;
									}

									System.out.println("Do you want to add more Categories? (y/n)");
									String cat_option = sc.nextLine();
									if (cat_option.toLowerCase().equals("n"))
										break;
								}
								break;

							case 2:
								// Category Operations
								System.out.println("------CATEGORY LIST------");
								ArrayList<Category> list_category = categorydaoimpl.getAllCategories();
								if (list_category.size() < 1) {
									System.out.println("Category has not been added");
								} else {
									for (int i = 0; i < list_category.size(); i++) {
										System.out.println((i + 1) + ")" + list_category.get(i).getInc_type());
									}
									System.out.println("Choose a category: ");
									int category_option = sc.nextInt();
									sc.nextLine();
									if (category_option > list_category.size()) {
										break;
									}

									// View after category is choosen
									System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
									System.out.println("XX      1.View Sub Category     XX");
									System.out.println("XX      2.Edit Category         XX");
									System.out.println("XX      3.Delete Category       XX");
									System.out.println("XX      4.Add Subcategory       XX");
									System.out.println("XX      5.Logout                XX");
									System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

									System.out.print("Enter your choice: ");
									int cat_choice = sc.nextInt();
									sc.nextLine();
									String category_id = list_category.get(category_option - 1).getCategory_id();

									switch (cat_choice) {

									// 1. View Sub Category
									case 1:
										System.out.println();
										System.out.println("------SUB CATEGORY LIST------");
										ArrayList<Subcategory> list_subcategory = subcategorydaoimpl
												.getSubCategoriesByCategoryID(category_id);
										if (list_subcategory.size() < 1) {
											System.out.println("Sub Category not found");
										} else {
											for (int i = 0; i < list_subcategory.size(); i++) {
												System.out.println(
														(i + 1) + ")" + list_subcategory.get(i).getSub_Catogory_type());
											}
											System.out.println("Choose a sub category: ");
											int sub_category_option = sc.nextInt();
											sc.nextLine();
											if (sub_category_option > list_subcategory.size()) {
												break;
											}
											// View after sub category is choosen
											System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
											System.out.println("XX      1.View Policies         XX");
											System.out.println("XX      2.Edit Sub Category     XX");
											System.out.println("XX      3.Delete Sub Category   XX");
											System.out.println("XX      4.Add Policy            XX");
											System.out.println("XX      5.Logout                XX");
											System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

											System.out.print("Enter your choice: ");
											int subcat_choice = sc.nextInt();
											sc.nextLine();
											String sub_category_id = list_subcategory.get(sub_category_option - 1)
													.getSub_catogory_id();

											switch (subcat_choice) {
											// 1. View Policies
											case 1:
												System.out.println("------POLICY LIST------");
												ArrayList<Policy> list_policy = policydaoimpl
														.getPolicyBySubCategoryID(sub_category_id);
												if (list_policy.size() < 1) {
													System.out.println("Policy not found");
												} else {
													for (int i = 0; i < list_policy.size(); i++) {
														System.out.println(
																(i + 1) + ")" + list_policy.get(i).getPlan_type());
														System.out.println("Monthly Premium = "
																+ list_policy.get(i).getMonthly_premium()
																+ "\t Coverage = " + list_policy.get(i).getCoverage()
																+ "\t Deductable = "
																+ list_policy.get(i).getDeductable());
													}
													System.out.println("Choose a Policy: ");
													int policy_option = sc.nextInt();
													sc.nextLine();
													if (policy_option > list_policy.size()) {
														break;
													}
													// View after category is choosen
													System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
													System.out.println("XX      1.Edit Policy           XX");
													System.out.println("XX      2.Delete Policy         XX");
													System.out.println("XX      3.Logout                XX");
													System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

													System.out.print("Enter your choice: ");
													int policy_choice = sc.nextInt();
													sc.nextLine();

													switch (policy_choice) {

													// 1.Edit Policy
													case 1:
														String policy_edit_id = list_policy.get(policy_choice - 1)
														.getPolicy_id();
														policydaoimpl.updatePolicy(policy_edit_id);
														break;

													// 2. Delete Policy
													case 2:
														String policy_delete_id = list_policy.get(policy_choice - 1)
														.getPolicy_id();
														policydaoimpl.deletePolicy(policy_delete_id);
													

													// 3. Logout
													case 3:
														break admin_loop;

													default:
														System.out.println("Invalid option");
														break;
													}
												}
												break;

											case 2:
												// 2. Edit Subcategory
												subcategorydaoimpl.updateSubCategory(sub_category_id);
												break;

											case 3:
												subcategorydaoimpl.deleteSubCategory(sub_category_id);
												// 3. Delete Subcategory
												break;
												
											
											case 4: 
												 policydaoimpl.addPolicy(category_id);
												// Add Policy
												break;
											
											case 5:
												// Cancel policy requests
												break;
												
											case 6:
												break admin_loop;

											default:
												System.out.println("Invalid option");
												break;
											}
										}
										break;

									// Edit Category
									case 2:
										categorydaoimpl.updateCategory(category_id);
										break;

									// Delete Category
									case 3:
										categorydaoimpl.deleteCategory(category_id);
										break;
									
									// Add Subcategory
									case 4:
										subcategorydaoimpl.addSubcategory(category_id);
										break;

									// LOGOUT
									case 5:
										break admin_loop;

									default:
										System.out.println("Invalid option");
										break;
									}

								}
								break;
							case 3:
								// Cutomer Operations
								ArrayList<Customer> list_customer = customerdaoimpl.getAllCustomer();
								// View after Cutomer Operations is choosen

								System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
								System.out.println("XX      1.View Customer         XX");
								System.out.println("XX      2.Logout                XX");
								System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
								System.out.println("Enter your choice: ");

								int view_customer = sc.nextInt();
								sc.nextLine();
								System.out.println();
								// Customer choices
								switch (view_customer) {
								case 1:
									if (list_customer.size() < 1) {
										System.out.println("No customer has registered!");
									} else {
										System.out.println("List of all registered customer: ");

										for (int i = 0; i < list_customer.size(); i++) {
											System.out.println(
													(i + 1) + ")\t" + "Name: " + list_customer.get(i).getFullName()
															+ "\t" + "Address: " + list_customer.get(i).getAddress()
															+ "\t" + "Age: " + list_customer.get(i).getAge() + "\t"
															+ "\tPhone number: " + list_customer.get(i).getPh_num()
															+ "\t" + "\tEmail: " + list_customer.get(i).getEmail());
											String cust_policy_id = list_customer.get(i).getPolicy_id();

											Policy cust_policy = policydaoimpl.getPolicyByID(cust_policy_id);

											System.out.println("------POLICY DETAILS----");

											if (cust_policy != null) {
												Subcategory cust_subcategory = subcategorydaoimpl
														.getSubCategoriesByID(cust_policy.getSub_category_id());

												Category cust_category = categorydaoimpl
														.getCategoriesByID(cust_subcategory.getCatogory_id());

												String applied = "No", accepted = "No";
												if (list_customer.get(i).isApplied() == true) {
													applied = "Yes";
													if (list_customer.get(i).isAccepted() == true) {
														accepted = "Yes";
													}
												}

												System.out.println("Category: " + cust_category.getInc_type() + "\t"
														+ "\tSub Category: " + cust_subcategory.getSub_Catogory_type()
														+ "\t" + "Policy: " + cust_policy.getPlan_type() + "\t"
														+ "\tMonthly Premium: " + cust_policy.getMonthly_premium()
														+ "\t" + "\tCoverage: " + cust_policy.getCoverage() + "\t"
														+ "\tDeductable: " + cust_policy.getDeductable() + "\tApplied: "
														+ applied + "\tAccepted: " + accepted);

											}

										}

									}
									break;

								case 2:
									break admin_loop;

								default:
									System.out.println("Invalid option");
									break;

								}

								break;

							case 4:
								// Pending Applications
								ArrayList<Customer> pending_application = customerdaoimpl.getPendingList();
								if (pending_application.size() > 0) {
									for (int i = 0; i < pending_application.size(); i++) {
										System.out.println(
												(i + 1) + ")\t" + "Name: " + pending_application.get(i).getFullName()
														+ "\t" + "Address: " + pending_application.get(i).getAddress()
														+ "\t" + "Age: " + pending_application.get(i).getAge() + "\t"
														+ "Phone number: " + pending_application.get(i).getPh_num()
														+ "\t" + "Email: " + pending_application.get(i).getEmail());
										String cust_policy_id = pending_application.get(i).getPolicy_id();

										Policy cust_policy = policydaoimpl.getPolicyByID(cust_policy_id);

										Subcategory cust_subcategory = subcategorydaoimpl
												.getSubCategoriesByID(cust_policy.getSub_category_id());

										Category cust_category = categorydaoimpl
												.getCategoriesByID(cust_subcategory.getCatogory_id());
										System.out.println("-------Policy Details------");

										System.out.println("Category: " + cust_category.getInc_type() + "\t"
												+ "Sub Category: " + cust_subcategory.getSub_Catogory_type() + "\t"
												+ "Policy: " + cust_policy.getPlan_type() + "\t" + "Monthly Premium: "
												+ cust_policy.getMonthly_premium() + "\t" + "Coverage: "
												+ cust_policy.getCoverage() + "\t" + "Deductable: "
												+ cust_policy.getDeductable());
									}

									System.out.println("Choose an option to accept application: ");
									int pending_option = sc.nextInt();
									sc.nextLine();
									if (pending_option > pending_application.size()) {
										System.out.println("Invalid option");
									} else {
										int index = pending_option - 1;
										admindaoimpl.acceptApplication(pending_application.get(index));
									}
								} else {
									System.out.println("No pending applications");
								}
								break;
							case 5:
								//Cancel policy requests
								ArrayList<Customer> cancel_application = customerdaoimpl.getCancelRequests();
								if (cancel_application.size() > 0) {
									for (int i = 0; i < cancel_application.size(); i++) {
										System.out.println(
												(i + 1) + ")\t" + "Name: " + cancel_application.get(i).getFullName()
														+ "\t" + "Address: " + cancel_application.get(i).getAddress()
														+ "\t" + "Age: " + cancel_application.get(i).getAge() + "\t"
														+ "Phone number: " + cancel_application.get(i).getPh_num()
														+ "\t" + "Email: " + cancel_application.get(i).getEmail());
										String cust_policy_id = cancel_application.get(i).getPolicy_id();

										Policy cust_policy = policydaoimpl.getPolicyByID(cust_policy_id);

										Subcategory cust_subcategory = subcategorydaoimpl
												.getSubCategoriesByID(cust_policy.getSub_category_id());

										Category cust_category = categorydaoimpl
												.getCategoriesByID(cust_subcategory.getCatogory_id());
										System.out.println("-------Policy Details------");

										System.out.println("Category: " + cust_category.getInc_type() + "\t"
												+ "Sub Category: " + cust_subcategory.getSub_Catogory_type() + "\t"
												+ "Policy: " + cust_policy.getPlan_type() + "\t" + "Monthly Premium: "
												+ cust_policy.getMonthly_premium() + "\t" + "Coverage: "
												+ cust_policy.getCoverage() + "\t" + "Deductable: "
												+ cust_policy.getDeductable());
									}

									System.out.println("Choose an option to cancel application: ");
									int pending_option = sc.nextInt();
									sc.nextLine();
									if (pending_option > cancel_application.size()) {
										System.out.println("Invalid option");
									} else {
										int index = pending_option - 1;
										admindaoimpl.adminCancelRequest(cancel_application.get(index));
									}
								} else {
									System.out.println("No pending applications");
								}
								break;
								
							case 6:
								// LOGOUT
								break admin_loop;

							default:
								System.out.println("Invalid option");
								break;
							}
						}
					} else {
						System.out.println("login failed. please try again!!");
					}
					break;
				}

				break;

			case 2:
				// Register view
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

				default:
					System.out.println("Invalid option");
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
				switch (for_choice) {
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

				default:
					System.out.println("Invalid option");
					break;
				}

				break;

			case 4:
				System.exit(0);

			default:
				System.out.println("Invalid option");
				break;
			}
			sc.close();
		}
		
	}

}