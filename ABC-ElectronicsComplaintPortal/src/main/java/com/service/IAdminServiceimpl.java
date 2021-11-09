package com.service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.lang.Throwable;
import java.sql.Date;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;import com.entities.Complaint;
import com.entities.Engineer;
import com.exceptions.InValidDomainException;
import com.exceptions.InvalidEngineerIdException;
import com.repository.IComplaintRepository;
//import com.cg.model.Product;
//import com.exception.InValidClientIdException;
//import com.repository.IComplaintRepository;
//import com.repository.IEngineerRepository;
//import com.repository.IProductRepository;
import com.repository.IEngineerRepository;
import com.repository.IProductRepository;@Service


public class IAdminServiceimpl implements IAdminService{


@Autowired
IEngineerRepository repo;
@Autowired
IComplaintRepository icr;
@Autowired
IProductRepository repoe;
@Override
public Engineer addEngineer(Engineer e) {
	repo.save(e);
	return e;
	
	
}
@Override
public Engineer changeDomain(int engineerId, String newDomain) throws InValidDomainException, InvalidEngineerIdException {
	Engineer c=new Engineer();
	Engineer id=repo.findById(engineerId).orElseThrow();
	id.setDomain(newDomain);
	repo.save(id);
	
	return id;
	
}
@Override
public String removeEngineer(int engineerId) throws InvalidEngineerIdException {
	Engineer c=new Engineer();
	Engineer id=repo.findById(engineerId).orElseThrow();
	repo.delete(id);
	return "deleted";
	
}
@Override
public List<Complaint> getComplaintsByProducts(String productCategoryName) {
	List<Complaint> lc1=icr.getComplaintsByProducts(productCategoryName);
	return lc1;	
}
@Override
public List<Complaint> getComplaints(String status) {
	List<Complaint> lc1=icr.getComplaints(status);
	return lc1;	
}
/*
 * @Override public Complaint replaceEngineerFromComplaint(int complaintId)
 * throws InValidDomainException { Complaint
 * a1=icr.findById(complaintId).orElseThrow();
 * 
 * 
 * 
 * 
 * }
 */
}