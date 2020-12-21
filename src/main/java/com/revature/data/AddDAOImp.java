package com.revature.data;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Reimbursement;
import com.revature.util.HibernateUtil;

public class AddDAOImp implements AddDAO{

	@Override
	public boolean addRequest(Reimbursement reimbursement) {
		
		System.out.println(reimbursement);
		
		Session session = HibernateUtil.getSession();
		
		//Transaction transaction = session.beginTransaction();
		
		session.save(reimbursement);
		
		//transaction.commit();
		
		//HibernateUtil.closeSession();
		
		return true;
	}
}
