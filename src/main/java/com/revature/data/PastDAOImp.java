package com.revature.data;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Reimbursement;
import com.revature.util.HibernateUtil;

public class PastDAOImp implements PastDAO {

	@Override
	public List<Reimbursement> getRequests(int userId) {
		Session session = HibernateUtil.getSession();
		
		String query = "FROM Reimbursement WHERE author = '" + userId + "'";
		
		List<Reimbursement> requests = session.createQuery(query).list();
		
		HibernateUtil.closeSession();
		
		return requests;
	}

}
