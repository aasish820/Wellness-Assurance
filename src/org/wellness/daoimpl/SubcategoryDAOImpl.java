package org.wellness.daoimpl;

import java.util.ArrayList;
import java.util.Scanner;
import org.wellness.dao.SubcategoryDAO;
import org.wellness.model.Subcategory;

public class SubcategoryDAOImpl implements SubcategoryDAO {

	Scanner sc = new Scanner(System.in);
	ArrayList<Subcategory> subcategory = new ArrayList<Subcategory>();
	
	@Override
	public ArrayList<Subcategory> getSubCategoriesByCategoryID(String category_id) {
		
		ArrayList<Subcategory> subcategoryByCategory = new ArrayList<Subcategory>();
		for(Subcategory sub_category_list: subcategory) {
			if(sub_category_list.getCatogory_id() == category_id) {
				subcategoryByCategory.add(sub_category_list);
			}
		}
		return subcategoryByCategory;
	}
	
	@Override
	public String addSubcategory(String category_id) {
		
		System.out.println("Enter Subcategory ID");
		String sub_catogory_id = sc.nextLine();
		
		System.out.println("Enter Subcategory Type");
		String sub_Catogory_type = sc.nextLine();
		
		Subcategory subcategory_obj = new Subcategory(sub_catogory_id, category_id, sub_Catogory_type); 
		subcategory.add(subcategory_obj);
		System.out.println("Sub category Added Successfully");
		
		String sub_id = subcategory_obj.getSub_catogory_id();
		return sub_id;
		
	}
	
	@Override
	public void updateSubCategory(String sub_category_id) {
		// TODO Auto-generated method stub
		System.out.println("Enter new Sub Category Type: ");
		String sub_category_type = sc.nextLine();
		boolean flag = false;
		for(Subcategory sub_category_list: subcategory) {
			if(sub_category_list.getSub_catogory_id() == sub_category_id) {
				sub_category_list.setSub_Catogory_type(sub_category_type);;
				flag = true;
			}
		}
		if(flag == true) System.out.println("Sub Category updated Successfully");
		else System.out.println("Sub Category could not be updated");
	}

	@Override
	public void deleteSubCategory(String sub_category_id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for(Subcategory sub_category_list: subcategory) {
			if(sub_category_list.getSub_catogory_id() == sub_category_id) {
				subcategory.remove(sub_category_list);
				flag = true;
			}
		}
		if(flag == true) System.out.println("Category deleted Successfully");
		else System.out.println("Category could not be deleted");
	}

	@Override
	public Subcategory getSubCategoriesByID(String sub_category_id) {
		// TODO Auto-generated method stub
		for(Subcategory sub_category_list: subcategory) {
			if(sub_category_list.getSub_catogory_id() == sub_category_id) {
				return sub_category_list;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Subcategory> getAllSubCategories() {
		// TODO Auto-generated method stub
		return subcategory;
	}

}
