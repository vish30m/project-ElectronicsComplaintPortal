package com.service;


import java.time.LocalDate;
import java.util.List;

import com.entities.Complaint;
import com.entities.Engineer;



public interface IEngineerService {

	public Engineer addEngineer(Engineer e);
	public List<Complaint> getAllOpenComplaints1(int engineerId);
	public List<Complaint> getResolvedComplaints1(int engineerId);
	public List<Complaint> getComplaints(int engineerId);
	public String changeComplaintStatus(int complaintId) throws Throwable; // returns updated Status;	
}
