package models;

import java.util.Map;

public class Bill {
	private String name;
	private double amount;
	private Map<User, Double> paidBy, ownedBy;
	
	public Bill(String name, double amount, Map<User, Double> paidBy, Map<User, Double> ownedBy) {
		super();
		this.name = name;
		this.amount = amount;
		this.paidBy = paidBy;
		this.ownedBy = ownedBy;
	}

	public Map<User, Double> getPaidBy() {
		return paidBy;
	}

	public void setPaidBy(Map<User, Double> paidBy) {
		this.paidBy = paidBy;
	}

	public Map<User, Double> getOwnedBy() {
		return ownedBy;
	}

	public void setOwnedBy(Map<User, Double> ownedBy) {
		this.ownedBy = ownedBy;
	}

	public String getName() {
		return name;
	}

	public double getAmount() {
		return amount;
	}
	
}
