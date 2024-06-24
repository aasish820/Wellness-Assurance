package org.wellness.daoimpl;

import java.util.ArrayList;
import java.util.Scanner;

import org.wellness.dao.CategoryDAO;
import org.wellness.model.Category;
import org.wellness.model.Policy;
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
			System.out.println("Category Added Successfully");
			
			// Getting all the subcategories based on category
			SubcategoryDAOImpl subcategorydaoimpl_obj = new SubcategoryDAOImpl();
//			 ArrayList<Subcategory> list_sub_category = subcategorydaoimpl_obj.getSubCategoriesByCategoryID(category_obj.getCategory_id());
			while(true) {
				//Adding sub category
				System.out.println("Enter sub category info for " + category_obj.getInc_type());
				String sub_id = subcategorydaoimpl_obj.addSubcategory(category_obj.getCategory_id());
				System.out.println("Sub category Added Successfully");
				
				while(true) {
					// Add Policy
					System.out.println("Enter Policy ID");
					String policy_id = sc.nextLine();
					System.out.println("Enter Plan Type");
					String plan_type = sc.nextLine();
					System.out.println("Enter Monthly Premium: ");
					Double monthly_premium = sc.nextDouble();
					sc.nextLine();
					System.out.println("Enter Coverage: ");
					Double coverage = sc.nextDouble();
					sc.nextLine();
					System.out.println("Deductable: ");
					Double deductable = sc.nextDouble();
					sc.nextLine();
					
					PolicyDAOImpl policydaoimpl_obj = new PolicyDAOImpl();
//					ArrayList<Policy> list_policy = policydaoimpl_obj.getPolicyBySubCategoryID(subcategorydaoimpl_obj.getSubCategoriesByCategoryID());
					policydaoimpl_obj.addPolicy(sub_id);
					
					System.out.println("Policy Added Successfully");
					System.out.println("Do you want to add more Policy? (y/n)");
					String policy_option = sc.nextLine();
					if(policy_option.toLowerCase().equals("n")) break;
				}
				
				System.out.println("Do you want to add more Sub categories? (y/n)");
				String sub_option = sc.nextLine();
				if(sub_option.toLowerCase().equals("n")) break;
			}
			
			System.out.println("Do you want to add more Categories? (y/n)");
			String cat_option = sc.nextLine();
			if(cat_option.toLowerCase().equals("n")) break;
		}
				
//				while(true) {
//					System.out.println("Enter sub category info for " + category_obj.getInc_type());
//					subcategorydaoimpl_obj.addSubcategory(category_obj.getCategory_id());
//					System.out.println("Sub category Added Successfully");
//				}
				
//			}
			
			
		
	}

}
