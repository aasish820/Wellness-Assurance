package org.wellness.daoimpl;

import java.util.ArrayList;
import java.util.Scanner;

import org.wellness.dao.CategoryDAO;
import org.wellness.model.Category;

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
			System.out.println("Category Added Successfully");	
		
	}
	
	@Override
	public void updateCategory(String category_id) {
		// TODO Auto-generated method stub
		System.out.println("Enter new Category Type: ");
		String category_type = sc.nextLine();
		boolean flag = false;
		for(Category category_list: category) {
			if(category_list.getCategory_id() == category_id) {
				category_list.setInc_type(category_type);
				flag = true;
			}
		}
		if(flag == true) System.out.println("Category updated Successfully");
		else System.out.println("Category could not be updated");
	}

	@Override
	public void deleteCategory(String category_id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for(Category category_list: category) {
			if(category_list.getCategory_id() == category_id) {
				category.remove(category_list);
				flag = true;
			}
		}
		if(flag == true) System.out.println("Category deleted Successfully");
		else System.out.println("Category could not be deleted");
	}
	
	@Override
	public Category getCategoriesByID(String category_id) {
		// TODO Auto-generated method stub
		for(Category category_list: category) {
			if(category_list.getCategory_id() == category_id) {
				return category_list;
			}
		}
		return null;
	}

}
