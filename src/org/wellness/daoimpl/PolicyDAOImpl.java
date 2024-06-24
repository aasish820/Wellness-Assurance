package org.wellness.daoimpl;

import java.util.ArrayList;
import java.util.Scanner;

import org.wellness.dao.PolicyDAO;
import org.wellness.model.Policy;

public class PolicyDAOImpl implements PolicyDAO {
	
	Scanner sc = new Scanner(System.in);

	@Override
	public ArrayList<Policy> getPolicyBySubCategoryID(String sub_category_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPolicy(String sub_category_id) {
		// TODO Auto-generated method stub
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
		
		Policy policy = new Policy(policy_id, plan_type, sub_category_id, monthly_premium, coverage, deductable);
		
	}

}
