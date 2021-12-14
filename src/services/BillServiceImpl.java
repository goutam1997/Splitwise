package services;

import java.util.Map;

import exceptions.GroupNotFoundException;
import models.Bill;
import models.Group;
import models.User;

public class BillServiceImpl implements BillService {
	GroupService groupService = new GroupServiceImpl();
	
	@Override
	public Map<String, Double> getEachUserBalanceInGroup(String groupName) {
//		Map<String, Double> u
		return null;
	}

	@Override
	public void addBillToGroup(Bill bill, String groupName) throws GroupNotFoundException {
		Group group = groupService.getGroup(groupName);
		
		bill.getPaidBy().forEach((user, paid) -> user.setBalance(user.getBalance() + paid));
		bill.getOwnedBy().forEach((user, owned) -> user.setBalance(user.getBalance() - owned));
	}

}
