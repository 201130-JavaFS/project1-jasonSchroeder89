package com.revature.services;

import java.util.List;

import com.revature.data.PastDAO;
import com.revature.data.PastDAOImp;
import com.revature.models.Reimbursement;
import com.revature.models.User;

public class PastService {
	private PastDAO pastDAO = new PastDAOImp();
	
	public List<Reimbursement> getRequests(User user) {
		if (user.getRole_id() != 1) {
			return pastDAO.getAllRequests();
		}
		
		return pastDAO.getRequests(user.getUser_id());
	}

}
