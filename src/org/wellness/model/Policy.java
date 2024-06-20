package org.wellness.model;

public class Policy {

	private String policy_id;
	private String plan_type;
	private String sub_category_id;
	private Double monthly_premium;
	private Double coverage;
	private Double deductable;

	public Policy(String policy_id, String plan_type, String sub_category_id, Double monthly_premium, Double coverage,
			Double deductable) {
		super();
		this.policy_id = policy_id;
		this.plan_type = plan_type;
		this.sub_category_id = sub_category_id;
		this.monthly_premium = monthly_premium;
		this.coverage = coverage;
		this.deductable = deductable;
	}
	
	public Policy() {
		super();
		
	}

	public String getPolicy_id() {
		return policy_id;
	}

	public void setPolicy_id(String policy_id) {
		this.policy_id = policy_id;
	}

	public String getPlan_type() {
		return plan_type;
	}

	public void setPlan_type(String plan_type) {
		this.plan_type = plan_type;
	}

	public String getSub_category_id() {
		return sub_category_id;
	}

	public void setSub_category_id(String sub_category_id) {
		this.sub_category_id = sub_category_id;
	}

	public Double getMonthly_premium() {
		return monthly_premium;
	}

	public void setMonthly_premium(Double monthly_premium) {
		this.monthly_premium = monthly_premium;
	}

	public Double getCoverage() {
		return coverage;
	}

	public void setCoverage(Double coverage) {
		this.coverage = coverage;
	}

	public Double getDeductable() {
		return deductable;
	}

	public void setDeductable(Double deductable) {
		this.deductable = deductable;
	}

}
