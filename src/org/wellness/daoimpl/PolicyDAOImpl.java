package org.wellness.daoimpl;

import java.util.ArrayList;
import java.util.Scanner;

import org.wellness.dao.PolicyDAO;
import org.wellness.model.Policy;

public class PolicyDAOImpl implements PolicyDAO {
	
	Scanner sc = new Scanner(System.in);
	ArrayList<Policy> policy = new ArrayList<Policy>();

	@Override
	public ArrayList<Policy> getPolicyBySubCategoryID(String sub_category_id) {
		// TODO Auto-generated method stub
		ArrayList<Policy> policy_new_list = new ArrayList<Policy>();
		for(Policy policy_list: policy) {
			if(policy_list.getSub_category_id() == sub_category_id) {
				policy_new_list.add(policy_list);
			}
		}
		return policy_new_list;
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
		
		Policy policy_obj = new Policy(policy_id, plan_type, sub_category_id, monthly_premium, coverage, deductable);
		policy.add(policy_obj);
		System.out.println("Policy Added Successfully");

	}
	
	@Override
	public void updatePolicy(String policy_id) {
		// TODO Auto-generated method stub
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
		
		boolean flag = false;
		for(Policy policy_list: policy) {
			if(policy_list.getPolicy_id() == policy_id) {
				policy_list.setPlan_type(plan_type);
				policy_list.setMonthly_premium(monthly_premium);
				policy_list.setCoverage(coverage);
				policy_list.setDeductable(deductable);
				flag = true;
			}
		}
		if(flag == true) System.out.println("Policy deleted Successfully");
		else System.out.println("Policy could not be deleted");
	}
	
	@Override
	public void deletePolicy(String policy_id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		for(Policy policy_list: policy) {
			if(policy_list.getPolicy_id() == policy_id) {
				policy.remove(policy_list);
				flag = true;
			}
		}
		if(flag == true) System.out.println("Policy deleted Successfully");
		else System.out.println("Policy could not be deleted");
	}
	
	@Override
	public Policy getPolicyByID(String cust_policy_id) {
		// TODO Auto-generated method stub
		for(Policy policy_list: policy) {
			if(policy_list.getPolicy_id() == cust_policy_id) {
				return policy_list;
			}
		}
		return null;
	}


}
