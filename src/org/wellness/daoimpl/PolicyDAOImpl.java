package org.wellness.daoimpl;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
	public String addPolicy(String sub_category_id) {
		// TODO Auto-generated method stub
		System.out.println("Enter Policy ID");
		String policy_id = sc.nextLine();
		
		System.out.println("Enter Plan Type");
		String plan_type = sc.nextLine();
		
//		System.out.println("Enter Monthly Premium: ");
//		Double monthly_premium = sc.nextDouble();
//		sc.nextLine();
//		System.out.println("Enter Coverage: ");
//		Double coverage = sc.nextDouble();
//		sc.nextLine();
//		System.out.println("Deductable: ");
//		Double deductable = sc.nextDouble();
//		sc.nextLine();
		
		 Double monthly_premium = getValidDoubleInput("Enter Monthly Premium: ");
		    Double coverage = getValidDoubleInput("Enter Coverage: ");
		    Double deductable = getValidDoubleInput("Enter Deductable: ");

		
		Policy policy_obj = new Policy(policy_id, plan_type, sub_category_id, monthly_premium, coverage, deductable);
		ArrayList<String> validate = validatePolicy(policy_obj);
		if (validate.size() < 1) {
			boolean result = policy.add(policy_obj);

			if (result == true) {

				System.out.println("New Policy Added Successfully");
			} else {

				System.out.println("Failed to add new policy. Please Try Again");
			}
		} else {
			System.out.println("Addition failed");
			for (int i = 0; i < validate.size(); i++) {
				System.out.println("!!!!!   " + validate.get(i) + "   !!!!!!");
			}
			String result = addPolicy(sub_category_id);
			System.out.println(result);
		}
		
		String pol_id = policy_obj.getSub_category_id();
		return pol_id;

	}
	
	
	private ArrayList<String> validatePolicy(Policy policy) {
		ArrayList<String> msg = new ArrayList<String>();

		if (policy.getPolicy_id().length() < 1 || policy.getPolicy_id().length() > 10) {
			msg.add("Policy ID has to be between 1 and 10 characters");
		}

		if (policy.getPlan_type().length() < 1) {
			msg.add("Plan Type cannot be empty");
		}
		
		if (policy.getMonthly_premium().toString().length() < 1) {
			msg.add("Monthly Premium cannot be empty");
		}
		if (policy.getCoverage().toString().length() < 1) {
			msg.add("Coverage cannot be empty");
		}
		if (policy.getDeductable().toString().length() < 1) {
			msg.add("Plan Type cannot be empty");
		}

		return msg;
	}
	
	private Double getValidDoubleInput(String message) {
	    Double value = null;
	    boolean validInput = false;

	    while (!validInput) {
	        try {
	            System.out.println(message);
	            value = sc.nextDouble();
	            sc.nextLine(); // Consume newline left-over
	            validInput = true; // If no exceptions, input is valid
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid numeric value.");
	            sc.nextLine(); // Clear the buffer
	        }
	    }

	    return value;
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
		if(flag == true) System.out.println("Policy updated Successfully");
		else System.out.println("Policy could not be updated");
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
