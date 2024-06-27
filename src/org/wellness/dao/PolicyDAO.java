package org.wellness.dao;

import java.util.ArrayList;

import org.wellness.model.Policy;

public interface PolicyDAO {
	ArrayList<Policy> getPolicyBySubCategoryID(String sub_category_id);

	String addPolicy(String sub_category_id);

	void updatePolicy(String policy_id);
	
	void deletePolicy(String policy_id);

	Policy getPolicyByID(String cust_policy_id);
}
