package com.revature.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.revature.services.AuthService;
import com.revature.models.User;

class AuthServiceTest {

	@Test
	void testLogin() {
		AuthService test = new AuthService();
		User testUser = new User(
				3, "mockuser", "mockuser", "Mock", "User", "fake@email.net", 1 );
		
		Assertions.assertEquals(test.login(testUser), testUser);
	}

}
