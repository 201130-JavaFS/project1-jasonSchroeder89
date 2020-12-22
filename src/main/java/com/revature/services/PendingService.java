package com.revature.services;

import java.util.List;

import com.revature.data.PendingDAO;
import com.revature.data.PendingDAOImp;
import com.revature.models.Reimbursement;

public class PendingService {

	private PendingDAO pendingDAO = new PendingDAOImp();
	
	public List<Reimbursement> getPending() {
		return pendingDAO.getPending();
	}

}
