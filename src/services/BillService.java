package services;

import java.util.Map;

import exceptions.GroupNotFoundException;
import models.Bill;
import models.User;

public interface BillService {
	Map<String, Double> getEachUserBalanceInGroup(String groupName);
	void addBillToGroup(Bill bill, String groupName) throws GroupNotFoundException;
}
