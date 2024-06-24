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
		while(true) {
			System.out.println("Enter Category ID");
			String category_id = sc.nextLine();
			System.out.println("Enter Category Type");
			String category_type = sc.nextLine();
			
			Category category_obj = new Category(category_id, category_type);
			category.add(category_obj);
			
			// Getting all the subcategories based on category
			SubcategoryDAOImpl subcategorydaoimpl_obj = new SubcategoryDAOImpl();
			ArrayList<Subcategory> list_sub_category = subcategorydaoimpl_obj.getSubCategoriesByCategoryID(category_obj.getCategory_id());
			while(true) {
				System.out.println("Enter sub category info for " + category_obj.getInc_type());
				subcategorydaoimpl_obj.addSubcategory(category_obj.getCategory_id());
				System.out.println("Sub category Added Successfully");
				System.out.println("Do you want to add more sub-categories? (y/n)");
				String option = sc.nextLine();
				if(option.toLowerCase() == "n") break;
			}
			System.out.println("Category Added Successfully");
			System.out.println("Do you want to add more Categories? (y/n)");
			String cat_option = sc.nextLine();
			if(cat_option.toLowerCase() == "n") break;
		}
		
		
		//test case to see all the added categories
		ArrayList<Category> list_category = this.getAllCategories();
		
		for(int i = 0; i < list_category.size(); i++) {
			System.out.println(list_category.get(i).getInc_type());
		}
		// emd test case
		
	}

}
