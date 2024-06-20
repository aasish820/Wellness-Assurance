package org.wellness.dao;

public interface AdminDAO {
	void registerAdmin();

	boolean adminLogin(String username, String password);


	void AdminPasswordReset(String for_admin_username);
}
