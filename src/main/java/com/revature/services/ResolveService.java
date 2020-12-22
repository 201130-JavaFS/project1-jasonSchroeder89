package com.revature.services;

import com.revature.data.ResolveDAO;
import com.revature.data.ResolveDAOImp;
import com.revature.models.Reimbursement;

public class ResolveService {

	private ResolveDAO resolveDAO = new ResolveDAOImp();
	
	public boolean resolve(Reimbursement reimbursement) {
		return resolveDAO.resolve(reimbursement);		
	}
}
