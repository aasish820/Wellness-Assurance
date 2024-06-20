package org.wellness.model;

public class Category {

	private String category_id;
	private String inc_type;

	public String getCategory_id() {
		return category_id;

	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;

	}

	public String getInc_type() {
		return inc_type;
	}

	public void setInc_type(String inc_type) {
		this.inc_type = inc_type;
	}

	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String category_id, String inc_type) {
		super();
		this.category_id = category_id;
		this.inc_type = inc_type;
	}
}
