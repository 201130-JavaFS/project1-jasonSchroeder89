package com.revature.data;

import org.hibernate.Session;

import com.revature.models.Reimbursement;
import com.revature.util.HibernateUtil;

public class AddDAOImp implements AddDAO{

	@Override
	public boolean addRequest(Reimbursement reimbursement) {
		
		Session session = HibernateUtil.getSession();
		
		session.save(reimbursement);
		
		HibernateUtil.closeSession();
		
		return true;
	}
}
