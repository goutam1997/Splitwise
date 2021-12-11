import java.util.Arrays;

import exceptions.GroupNameExistsException;
import exceptions.UserNameExistsException;
import exceptions.UserNotFoundException;
import services.GroupService;
import services.GroupServiceImpl;
import services.UserService;
import services.UserServiceImpl;

public class Driver {
	public static void main(String args[]) throws GroupNameExistsException, UserNotFoundException, UserNameExistsException {
		UserService userService = new UserServiceImpl();
		
		userService.createUser("Goutam");
		userService.createUser("Piyush");
		userService.createUser("Kaushal");
		
		GroupService groupService = new GroupServiceImpl();
		groupService.createGroup("Blr flatmates", Arrays.asList("Goutam", "Piyush", "Kaushal"));
		
		System.out.println(userService.getUserBalance("Goutam"));
	}
}
