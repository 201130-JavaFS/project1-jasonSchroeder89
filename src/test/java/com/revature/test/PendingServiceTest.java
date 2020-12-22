package com.revature.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.revature.services.PendingService;
import com.revature.models.Reimbursement;

class PendingServiceTest {

	@Test
	void test() {
		PendingService test = new PendingService();
		Reimbursement testReim = new Reimbursement(
				2, 3.50, "Test", "", "For Testing Delete", 3, 0, 1, 1
				);
		
		List<Reimbursement> testList = new ArrayList();
		testList.add(testReim);
		
		Assertions.assertEquals(test.getPending(), testList);
		
	}

}
