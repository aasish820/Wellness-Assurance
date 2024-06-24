package org.wellness.dao;

import java.util.ArrayList;

import org.wellness.model.Policy;
import org.wellness.model.Subcategory;

public interface PolicyDAO {
	ArrayList<Policy> getPolicyBySubCategoryID(String sub_category_id);

	void addPolicy(String sub_category_id);
}
