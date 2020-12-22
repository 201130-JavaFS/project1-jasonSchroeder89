package com.revature.data;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Reimbursement;
import com.revature.util.HibernateUtil;

public class PendingDAOImp implements PendingDAO {

	@Override
	public List<Reimbursement> getPending() {
		Session session = HibernateUtil.getSession();
		
		String query = "FROM Reimbursement WHERE status_id=1";
		
		List<Reimbursement> pending = session.createQuery(query).list();
		
		HibernateUtil.closeSession();
		
		return pending;
	}

}
