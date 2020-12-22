package com.revature.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.revature.services.AddService;
import com.revature.models.Reimbursement;

class AddServiceTest {

	@Test
	void testAddRequest() {
		AddService test = new AddService();
		Reimbursement testReim = new Reimbursement(
				3.50, "Test", "", "For Testing Delete", 3, 0, 1, 1
				);
		
		Assertions.assertEquals(test.addRequest(testReim), true);
	}

}
