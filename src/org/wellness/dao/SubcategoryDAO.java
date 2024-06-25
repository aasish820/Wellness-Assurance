package org.wellness.dao;

import java.util.ArrayList;

import org.wellness.model.Subcategory;

public interface SubcategoryDAO {
	ArrayList<Subcategory> getSubCategoriesByCategoryID(String category_id);

	String addSubcategory(String category_id);

	void updateSubCategory(String sub_category_id);

	void deleteSubCategory(String sub_category_id);

	Subcategory getSubCategoriesByID(String sub_category_id);

	ArrayList<Subcategory> getAllSubCategories();
}
