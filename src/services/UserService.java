package services;

import java.util.List;

import exceptions.UserNameExistsException;
import exceptions.UserNotFoundException;
import models.User;

public interface UserService {
	void createUser(String userName) throws UserNameExistsException;
	User getUser(String userName) throws UserNotFoundException;
	double getUserBalance(String userName) throws UserNotFoundException;
	List<String> getUserBelongingGroup(String userName) throws UserNotFoundException;
}
