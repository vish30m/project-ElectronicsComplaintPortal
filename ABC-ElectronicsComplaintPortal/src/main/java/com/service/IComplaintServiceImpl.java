package com.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exceptions.InValidComplaintException;
import com.entities.Complaint;
import com.entities.Engineer;
import com.entities.Product;
import com.repository.IComplaintRepository;
import com.repository.IEngineerRepository;
import com.repository.IProductRepository;
@Service
public class IComplaintServiceImpl implements IComplaintService {
	@Autowired
	IComplaintRepository repo;
	@Autowired
	IEngineerRepository repoe;
	@Autowired
	IProductRepository repository1;
   @Override
	public List<Complaint> bookComplaint(List<Complaint> e) {
		repo.saveAll(e);
		return e;
	}
	@Override
	public boolean bookComplaints(Complaint complaint) {
		repo.save(complaint);
		int id=complaint.getComplaintId();	
		var a=repo.findById(id);
		System.out.println(id);
		if(a.isPresent()) {
			return true;
		}
		else {
		return false;
		}
	}
  @Override 
	  public String changeComplaintStatus(int complaintId, String status) throws Throwable 
     { 
	  Complaint a1=repo.findById(complaintId).orElseThrow();
	  a1.setStatus(status); 
	  repo.save(a1); 
	  Complaint a =repo.findById(complaintId).orElseThrow();
	  if(a.getStatus()== status) {
		return "successfully updated" ;
		} 
	  else { 
	    return "failed"; 
	    }				
	  }
	@Override
	public List<Complaint> getClientAllComplaints(String clientId) 
	{
		 List<Complaint> lc1=repo.getClientAllComplaints(clientId);
		 return lc1;	
	}
	@Override
	public List<Complaint> getClientAllOpenComplaints(String clientId)
	{
	List<Complaint> lc1=repo.getClientAllOpenComplaints(clientId, "open");
	return lc1;		
	} 
	@Override
	public List<Engineer> saveEngineer(List<Engineer> e1) 
	{
		repoe.saveAll(e1);
		return e1;
	}	  
	@Override
	public Engineer getEngineer(int complaintId) throws InValidComplaintException 
	{ 	
		Complaint a1=repo.findById(complaintId).orElseThrow();	
		var employeeId = a1.getEngineerId();
	    Engineer c=repoe.getEngineer(employeeId);    
		return c;
	}		
	@Override 
	public List<Product> saveProduct(List<Product> e2)
	{		 
		repository1.saveAll(e2); 
		return e2;
	}		
	@Override 
	public Product getProductByComplaint(int complaintId) throws InValidComplaintException
	{
    Complaint a1=repo.findById(complaintId).orElseThrow();
	Product c=new Product();
    c=repository1.getProductByComplaint1(a1.getProductModelNumber());
	return c;
    }
}