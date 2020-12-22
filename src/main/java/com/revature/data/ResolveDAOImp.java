package com.revature.data;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Reimbursement;
import com.revature.util.HibernateUtil;

public class ResolveDAOImp implements ResolveDAO {

	@Override
	public boolean resolve(Reimbursement reimbursement) {
		Session session = HibernateUtil.getSession();
		
		Transaction transaction = session.beginTransaction();
		
		Reimbursement temp = session.get(Reimbursement.class, 
				reimbursement.getReimb_id());
		
		temp.setStatus_id(reimbursement.getStatus_id());
		temp.setResolver(reimbursement.getResolver());
		
		System.out.println(temp.getStatus_id());
		
		session.update(temp);
		
		transaction.commit();
		
		HibernateUtil.closeSession();
		
		return true;
	}

}
