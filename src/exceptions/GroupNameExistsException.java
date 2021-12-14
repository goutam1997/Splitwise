package exceptions;

public class GroupNameExistsException extends Exception {
	public GroupNameExistsException(String groupName) {
		System.out.println("Group name " + groupName + " already exists");
	}
}
