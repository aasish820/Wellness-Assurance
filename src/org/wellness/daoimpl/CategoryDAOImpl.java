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
			
			ArrayList<String> validate = validateCategory(category_obj);
			if (validate.size() < 1) {
				boolean result = category.add(category_obj);

				if (result == true) {

					System.out.println("New Category Registered Successfully");
				} else {

					System.out.println("Failed to add new category. Please Try Again");
				}
			} else {
				System.out.println("Addition failed");
				for (int i = 0; i < validate.size(); i++) {
					System.out.println("!!!!!   " + validate.get(i) + "   !!!!!!");
				}
				addCategory();
			}	
		
	}
	
	private ArrayList<String> validateCategory(Category new_category_obj) {
		ArrayList<String> msg = new ArrayList<String>();

		if (new_category_obj.getCategory_id().length() < 1 || new_category_obj.getCategory_id().length() > 10) {
			msg.add("Category ID has to be between 1 and 10 characters");
		}

		if (new_category_obj.getInc_type().length() < 1) {
			msg.add("Insurance Type cannot be empty");
		}

		return msg;
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
