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
	private String policy_id;
	private boolean applied;
	private boolean accepted;
	private boolean cancel;


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

	public boolean isApplied() {
		return applied;
	}

	public void setApplied(boolean applied) {
		this.applied = applied;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	
	public boolean isCancel() {
		return cancel;
	}

	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}

	public Customer() {
		super();
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		if (customer_id.length() < 1 || customer_id.isEmpty()) {
			System.out.println("Customer ID is required");
		}
		if (customer_id.length() > 10) {
			System.out.println("Customer ID cannot be more than 10 characters");
		}
		this.customer_id = customer_id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		if (fullName == null || fullName.isEmpty()) {
			System.out.println("Full name is required");
		}
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (address == null || address.isEmpty()) {
			System.out.println("Address is required");
		}
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age <= 0) {
			System.out.println("Age is required and must be greater than zero");
		}
		this.age = age;
	}

	public String getPh_num() {
		return ph_num;
	}

	public void setPh_num(String ph_num) {
		if (ph_num == null || ph_num.isEmpty()) {
			System.out.println("Phone number is required");
		}
		if (!ph_num.matches("\\d{10}")) {
			System.out.println("Phone number must be exactly 10 digits");
		}
		this.ph_num = ph_num;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if (username == null || username.isEmpty()) {
			System.out.println("Username is required");
		}
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password == null || password.isEmpty()) {
			System.out.println("Password is required");
		}
		if (password.length() < 8) {
			System.out.println("Password must be at least 8 characters long");
		}
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email == null || email.isEmpty()) {
			System.out.println("Email is required");
		}
		if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
			System.out.println("Email format is invalid");
		}
		this.email = email;
	}

	public String getPolicy_id() {
		return policy_id;
	}

	public void setPolicy_id(String policy_id) {
		this.policy_id = policy_id;
	}

}
