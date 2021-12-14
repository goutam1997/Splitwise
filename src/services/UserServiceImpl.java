package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exceptions.UserNameExistsException;
import exceptions.UserNotFoundException;
import models.Group;
import models.User;

public class UserServiceImpl implements UserService {
	private static Map<String, User> users = new HashMap<>();

	@Override
	public void createUser(String userName) throws UserNameExistsException {
		if(users.containsKey(userName))
			throw new UserNameExistsException(userName);
		
		User user = new User(userName, 0.0);
		users.put(userName, user);
	}

	@Override
	public User getUser(String userName) throws UserNotFoundException {
		if(!users.containsKey(userName))
			throw new UserNotFoundException(userName);
		
		return users.get(userName);
	}
	
	public double getUserBalance(String userName) throws UserNotFoundException {
		return getUser(userName).getBalance();
	}
	
	public List<String> getUserBelongingGroup(String userName) throws UserNotFoundException{
		List<Group> userGroup = getUser(userName).getBelongingGroup();
		
		List<String> belongingGroupNames = new ArrayList<>();
		userGroup.forEach(group -> belongingGroupNames.add(group.getName()));
		
		return belongingGroupNames;
	}
}
