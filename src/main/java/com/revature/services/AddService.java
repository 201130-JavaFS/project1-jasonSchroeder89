package com.revature.services;

import com.revature.data.AddDAO;
import com.revature.data.AddDAOImp;
import com.revature.models.Reimbursement;

public class AddService {

	private AddDAO addDAO = new AddDAOImp();
	
	public boolean addRequest(Reimbursement reimbursement) {
		
		reimbursement.setResolver(0);
		
		reimbursement.setTime_resolved("");
		
		reimbursement.setStatus_id(1);
		
		return addDAO.addRequest(reimbursement);
	}
}
