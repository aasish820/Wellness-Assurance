package org.wellness.daoimpl;

import java.util.ArrayList;
import java.util.Scanner;

import org.wellness.dao.CategoryDAO;
import org.wellness.model.Category;
import org.wellness.model.Subcategory;

public class CategoryDAOImpl implements CategoryDAO {
	
	Scanner sc = new Scanner(System.in);
	ArrayList<Category> category = new ArrayList<Category>();
	
	@Override
	public ArrayList<Category> getAllCategories() {
		return category;
	}
	
	@Override
	public void addCategory() {
		// TODO Auto-generated method stub
		System.out.println("Enter Category ID");
		String category_id = sc.nextLine();
		System.out.println("Enter Category Type");
		String category_type = sc.nextLine();
		
		Category category_obj = new Category(category_id, category_type);
		category.add(category_obj);
		
		SubcategoryDAOImpl subcategorydaoimpl_obj = new SubcategoryDAOImpl();
		ArrayList<Subcategory> list_sub_category = subcategorydaoimpl_obj.getSubCategoriesByID();
	}

}
