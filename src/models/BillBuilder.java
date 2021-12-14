package models;

import java.util.HashMap;
import java.util.Map;

import exceptions.UserNotFoundException;
import services.UserServiceImpl;

public class BillBuilder {
	private String name;
	private double amount;
	private Map<String, Double> paidBy, ownedBy;
	
	public BillBuilder setName(String name) {
		this.name = name;
		return this;
	}
	
	public BillBuilder setAmount(double amount) {
		this.amount = amount;
		return this;
	}

	public BillBuilder setPaidBy(Map<String, Double> paidBy) {
		this.paidBy = paidBy;
		return this;
	}

	public BillBuilder setOwnedBy(Map<String, Double> ownedBy) {
		this.ownedBy = ownedBy;
		return this;
	}
	
	public Bill getBill() {
		Map<User, Double> pd = new HashMap<>(), ow = new HashMap<>();
		
		paidBy.forEach((userName, value)-> {
			try {
				pd.put(new UserServiceImpl().getUser(userName), value);
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		ownedBy.forEach((userName, value)-> {
			try {
				ow.put(new UserServiceImpl().getUser(userName), value);
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Bill bill = new Bill(name, amount, pd, ow);
		return bill;
	}
}
