package org.wellness.model;

public class Admin {
	
	private String admin_id;
	private String fullName;
	private String address;
	private String ph_num;
	private String username;
	private String password;
	private String email;
	
	public Admin(String admin_id, String fullName, String address, String ph_num, String username, String password, String email) {
		super();
		this.admin_id = admin_id;
		this.fullName = fullName;
		this.address = address;
		this.ph_num = ph_num;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public Admin() {
		super();
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		if(fullName.equals(null))
			System.out.println("this is required");
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPh_num() {
		return ph_num;
	}

	public void setPh_num(String ph_num) {
		if(ph_num.length()!=10) {
			System.out.println("Mobile number shoud be 10 digit");
		}
		this.ph_num = ph_num;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if(username.length()==0)
			System.out.println("User Name can't be null");
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
