package models;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String name;
	private double balance;
	private List<Group> belongingGroup;
	
	public User(String name, double balance) {
		super();
		this.name = name;
		this.balance = balance;
		belongingGroup = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Group> getBelongingGroup() {
		return belongingGroup;
	}

	public void setBelongingGroup(List<Group> belongingGroup) {
		this.belongingGroup = belongingGroup;
	}
	
	public void addInGroup(Group group) {
		belongingGroup.add(group);
	}
}
