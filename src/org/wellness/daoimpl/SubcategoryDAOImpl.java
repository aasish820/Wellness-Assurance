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
		return subcategory;
	}
	
	@Override
	public String addSubcategory(String category_id) {
		
		System.out.println("Enter Subcategory ID");
		String sub_catogory_id = sc.nextLine();
		
		System.out.println("Enter Subcategory Type");
		String sub_Catogory_type = sc.nextLine();
		
		Subcategory subcategory_obj = new Subcategory(sub_catogory_id, category_id, sub_Catogory_type); 
		subcategory.add(subcategory_obj);
		String sub_id = subcategory_obj.getSub_catogory_id();
		return sub_id;
		
	}

}
