package com.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.lang.Throwable;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.exceptions.InValidClientIdException;
import com.exceptions.InvalidEngineerIdException;
import com.entities.Complaint;
import com.entities.Engineer;
import com.repository.IComplaintRepository;
import com.repository.IEngineerRepository;

@Service
public class IEngineerServiceimpl implements IEngineerService {
	@Autowired
	IEngineerRepository repo;
	@Autowired
	IComplaintRepository icr;

	public Engineer addEngineer(Engineer e)
	{
		 repo.save(e);	
		 return e;
	}
	
	
	@Override
	public List<Complaint> getAllOpenComplaints1(int engineerId) {
		Supplier s1=()->new InvalidEngineerIdException("Invalid Engineer ID");
		List<Complaint> l1 = icr.getAllOpenComplaints1(engineerId);
		return l1;
	}

	@Override
	public List<Complaint> getResolvedComplaints1(int engineerId){
		Supplier s1=()->new InvalidEngineerIdException("Invalid Engineer ID");
		List<Complaint> l1 = icr.getResolvedComplaints1(engineerId);
		return l1;
	}

	@Override
	public List<Complaint> getComplaints(int engineerId) {
		List<Complaint> l1 = icr.findAllComplaints(engineerId);
		return l1;
	}

	@Override
	public String changeComplaintStatus(int complaintId) throws Throwable {
		Supplier s1=()->new InvalidEngineerIdException("Id does not Exist");
		Complaint c1 = icr.findById(complaintId).orElseThrow(s1);
		if (c1.getStatus().equalsIgnoreCase("open") ){
			c1.setStatus("resolved");
			icr.save(c1);
		}
		return "status updated";
	}
}