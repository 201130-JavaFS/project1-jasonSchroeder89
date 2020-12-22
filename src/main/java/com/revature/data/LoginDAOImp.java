package com.revature.data;

import org.hibernate.Session;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class LoginDAOImp implements LoginDAO {

	@Override
	public User login(User user) {
		Session session = HibernateUtil.getSession();
		
		String query = 
				"FROM User WHERE username = '" + user.getUsername() + "'";
		
		try {
			User validUser = (User) session.createQuery(query).getSingleResult();
			
			HibernateUtil.closeSession();
			
			if (validUser != null && validUser.getPassword()
					.equals(user.getPassword())) {
				
				return validUser;
			}
			
			else {
				return null;
			}
		}
		
		catch (Exception e) {
			return null;
		}			
	}
}
