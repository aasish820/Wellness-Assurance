package org.wellness.dao;

public interface CustomerDAO {
	void registerCustomer();
	boolean customerLogin(String username, String password);
	void CustomerPasswordReset(String for_cus_username);
}
