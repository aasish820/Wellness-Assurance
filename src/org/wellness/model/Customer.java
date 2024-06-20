package org.wellness.model;

public class Customer {

	private String customer_id;
	private String fullName;
	private String address;
	private int age;
	private String ph_num;
	private String username;
	private String password;
	private String email;
	private int policy_id;

	public Customer(String customer_id, String fullName, String address, int age, String ph_num, String username,
			String password, String email) {
		super();
		this.customer_id = customer_id;
		this.fullName = fullName;
		this.address = address;
		this.age = age;
		this.ph_num = ph_num;
		this.username = username;
		this.password = password;
		this.email = email;

	}
	
	public Customer() {
		super();
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPh_num() {
		return ph_num;
	}

	public void setPh_num(String ph_num) {
		this.ph_num = ph_num;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
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

	public int getPolicy_id() {
		return policy_id;
	}

	public void setPolicy_id(int policy_id) {
		this.policy_id = policy_id;
	}

}
