package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group {
	private String name;
	private Map<User, Double> membersBalance;
	
	public Group(String name, List<User> members) {
		super();
		this.name = name;
		membersBalance = new HashMap<>();
		members.forEach(member -> membersBalance.put(member, 0.0));
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getMemberNames() {
		List<String> members = new ArrayList<>();
		membersBalance.forEach((member, balance) -> members.add(member.getName()));
		return members;
	}
	public void setMembers(List<User> members) {
		if(membersBalance == null)
			membersBalance = new HashMap<>();
		members.forEach(member -> membersBalance.put(member, 0.0));
	}
	public void addUserToGroup(User user) {
		membersBalance.put(user, 0.0);
	}
}
