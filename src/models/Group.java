package models;

import java.util.List;

public class Group {
	private String name;
	private List<User> members;
	
	public Group(String name, List<User> members) {
		super();
		this.name = name;
		this.members = members;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getMembers() {
		return members;
	}
	public void setMembers(List<User> members) {
		this.members = members;
	}
	public void addUserToGroup(User user) {
		members.add(user);
	}
}
