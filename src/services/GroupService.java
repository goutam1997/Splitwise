package services;

import java.util.List;

import exceptions.GroupNameExistsException;
import exceptions.GroupNotFoundException;
import models.Group;
import models.User;

public interface GroupService {
	void createGroup(String groupName, List<String> members) throws GroupNameExistsException;
	Group getGroup(String groupName) throws GroupNotFoundException;
}
