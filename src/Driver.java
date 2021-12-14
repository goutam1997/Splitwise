import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import exceptions.GroupNameExistsException;
import exceptions.GroupNotFoundException;
import exceptions.UserNameExistsException;
import exceptions.UserNotFoundException;
import models.Bill;
import models.BillBuilder;
import services.BillServiceImpl;
import services.GroupService;
import services.GroupServiceImpl;
import services.UserService;
import services.UserServiceImpl;

public class Driver {
	public static void main(String args[]) throws GroupNameExistsException, UserNotFoundException, UserNameExistsException, GroupNotFoundException {
		UserService userService = new UserServiceImpl();

		userService.createUser("Goutam");
		userService.createUser("Piyush");
		userService.createUser("Kaushal");

		GroupService groupService = new GroupServiceImpl();
		groupService.createGroup("Blr flatmates", Arrays.asList("Goutam", "Piyush", "Kaushal"));

		Map<String, Double> paidBy = new HashMap<>(), ownedBy = new HashMap<>();
		paidBy.put("Goutam", 300.0);

		ownedBy.put("Goutam", 100.0);
		ownedBy.put("Piyush", 100.0);
		ownedBy.put("Kaushal", 100.0);

		Bill bill = new BillBuilder().setName("Rent").setAmount(300.0).setPaidBy(paidBy).setOwnedBy(ownedBy).getBill();

		new BillServiceImpl().addBillToGroup(bill, "Blr flatmates");
		
		groupService.getMemberNames("Blr flatmates").forEach(member -> 
				{
					try {
						System.out.println(member + "'s Balance -> " + userService.getUserBalance(member));
					} catch (UserNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});
	}
}
