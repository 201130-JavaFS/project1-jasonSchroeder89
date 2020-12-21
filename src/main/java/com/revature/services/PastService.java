package com.revature.services;

import java.util.List;

import com.revature.data.PastDAO;
import com.revature.data.PastDAOImp;
import com.revature.models.Reimbursement;

public class PastService {
	private PastDAO pastDAO = new PastDAOImp();
	
	public List<Reimbursement> getRequests(int userId) {
		return pastDAO.getRequests(userId);
	}

}
