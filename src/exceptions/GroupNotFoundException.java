package exceptions;

public class GroupNotFoundException extends Exception {
	public GroupNotFoundException(String groupName) {
		System.out.println("Group name " + groupName + " does not exist");
	}
}
