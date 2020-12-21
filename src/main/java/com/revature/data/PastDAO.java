package com.revature.data;

import java.util.List;

import com.revature.models.Reimbursement;

public interface PastDAO {
	
	public List<Reimbursement> getRequests(int userId);
}
