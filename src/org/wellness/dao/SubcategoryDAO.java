package org.wellness.dao;

import java.util.ArrayList;

import org.wellness.model.Subcategory;

public interface SubcategoryDAO {
	ArrayList<Subcategory> getSubCategoriesByCategoryID(String category_id);

	String addSubcategory(String category_id);
}
