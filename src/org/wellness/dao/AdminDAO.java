package org.wellness.dao;

import org.wellness.model.Customer;

public interface AdminDAO {
	void registerAdmin();

	boolean adminLogin(String username, String password);


	void AdminPasswordReset(String for_admin_username);

	void adminCancelRequest(Customer customer);

	void acceptApplication(Customer customer);
}
