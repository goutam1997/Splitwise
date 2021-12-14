package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exceptions.GroupNameExistsException;
import exceptions.GroupNotFoundException;
import exceptions.UserNotFoundException;
import models.Group;
import models.User;

public class GroupServiceImpl implements GroupService {
	private static Map<String, Group> groups = new HashMap<>();
	
	public void createGroup(String groupName, List<String> members) throws GroupNameExistsException {
		if(groups.containsKey(groupName))
			throw new GroupNameExistsException(groupName);
		
		List<User> memberUsers = new ArrayList<>();
		members.forEach(member -> {
			try {
				memberUsers.add(new UserServiceImpl().getUser(member));
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Group group=new Group(groupName, memberUsers);
		
		for(User member: memberUsers)
			member.addInGroup(group);
		
		groups.put(groupName, group);
	}
	
	public Group getGroup(String groupName) throws GroupNotFoundException {
		if(!groups.containsKey(groupName))
			throw new GroupNotFoundException(groupName);
		
		return groups.get(groupName);
	}
	
	public List<String> getMemberNames(String groupName) throws GroupNotFoundException {
		if(!groups.containsKey(groupName))
			throw new GroupNotFoundException(groupName);
		
		return groups.get(groupName).getMemberNames();
	}
}
