package com.revature.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.revature.services.PastService;
import com.revature.models.Reimbursement;
import com.revature.models.User;

class PastServiceTest {

	@Test
	void test() {
		PastService test = new PastService();
		User testUser = new User(
				4, "mockusera", "mockuser", "Mock", "User", "fake@email.net", 2 );
		
		Reimbursement testReim = new Reimbursement(
				1, 3.50, "Test", "", "For Testing Delete", 3, 0, 1, 1
				);
		
		List<Reimbursement> testList = new ArrayList();
		
		Assertions.assertEquals(test.getRequests(testUser), testList);		
	}

}
