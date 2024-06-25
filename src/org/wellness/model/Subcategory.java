package org.wellness.model;

public class Subcategory {
	private String sub_catogory_id;
	private String catogory_id;
	private String sub_Catogory_type;

	public String getSub_catogory_id() {
		return sub_catogory_id;
	}

	public void setSub_catogory_id(String sub_catogory_id) {
		this.sub_catogory_id = sub_catogory_id;
	}

	public String getCatogory_id() {
		return catogory_id;
	}

	public void setCatogory_id(String catogory_id) {
		this.catogory_id = catogory_id;
	}

	public String getSub_Catogory_type() {
		return sub_Catogory_type;
	}

	public void setSub_Catogory_type(String sub_Catogory_type) {
		this.sub_Catogory_type = sub_Catogory_type;
	}

	public Subcategory(String sub_catogory_id, String catogory_id, String sub_Catogory_type) {
		super();
		this.sub_catogory_id = sub_catogory_id;
		this.catogory_id = catogory_id;
		this.sub_Catogory_type = sub_Catogory_type;
	}

	public Subcategory() {
		super();
		// TODO Auto-generated constructor stub
	}

}
