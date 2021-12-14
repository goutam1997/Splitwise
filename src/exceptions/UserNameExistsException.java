package exceptions;

public class UserNameExistsException extends Exception {
	public UserNameExistsException(String userName) {
		System.out.println("User name " + userName + " already exists");
	}

}
