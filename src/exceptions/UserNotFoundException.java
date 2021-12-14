package exceptions;

public class UserNotFoundException extends Exception {
	public UserNotFoundException(String userName) {
		System.out.println("User name " + userName + " does not exist");
	}

}
