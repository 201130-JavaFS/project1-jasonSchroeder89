package com.revature.data;

import java.util.List;

import com.revature.models.Reimbursement;

public interface PendingDAO {

	public List<Reimbursement> getPending();
	
}
