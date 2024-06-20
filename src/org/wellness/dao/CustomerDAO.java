package org.wellness.dao;

public interface CustomerDAO {
	void registerCustomer();
	boolean customerLogin(String username, String password);
}
