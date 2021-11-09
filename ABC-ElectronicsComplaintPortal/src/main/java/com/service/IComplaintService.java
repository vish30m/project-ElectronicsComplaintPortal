package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.exceptions.InValidComplaintException;
import com.entities.Complaint;
import com.entities.Engineer;
import com.entities.Product;




@Service
public interface IComplaintService {
	
	public boolean bookComplaints(Complaint complaint);
	List<Complaint> bookComplaint(List<Complaint> e);
    public Engineer getEngineer(int complaintId)throws InValidComplaintException;
    List<Engineer> saveEngineer(List<Engineer> e1);
	List<Product> saveProduct(List<Product> e2);
    String changeComplaintStatus(int complaintId, String status) throws Throwable;
    List<Complaint> getClientAllComplaints(String clientId);
    List<Complaint> getClientAllOpenComplaints(String clientId);
    Product getProductByComplaint(int complaintId) throws InValidComplaintException;

	
}
