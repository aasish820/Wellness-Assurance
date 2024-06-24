package org.wellness.dao;

import java.util.ArrayList;

import org.wellness.model.Category;

public interface CategoryDAO {
	 ArrayList<Category> getAllCategories();
	 void addCategory();
}
