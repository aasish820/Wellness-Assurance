package org.wellness.dao;

import java.util.ArrayList;

import org.wellness.model.Category;

public interface CategoryDAO {
	ArrayList<Category> getAllCategories();
	void addCategory();
	void updateCategory(String category_id);
	void deleteCategory(String category_id);
	Category getCategoriesByID(String category_id);
}
