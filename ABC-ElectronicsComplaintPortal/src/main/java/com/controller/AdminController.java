package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Complaint;
import com.entities.Engineer;
import com.exceptions.InValidDomainException;
import com.exceptions.InvalidEngineerIdException;
//import com.service.IAdminServiceimpl;
import com.service.IAdminServiceimpl;

@RestController
@RequestMapping(path="/api")
public class AdminController {
	@Autowired
	IAdminServiceimpl iadmin;
	@PostMapping("/addEngineer")
	public Engineer addEngineer(@RequestBody Engineer e)  {
		Engineer d=iadmin.addEngineer(e);
		return d;
	}
	@PutMapping("/changeDomain/{engineerId}")
	public ResponseEntity<Engineer> changeDomain(@PathVariable int engineerId, @RequestBody String newDomain)
			throws InValidDomainException, InvalidEngineerIdException{
		Engineer a1=iadmin.changeDomain(engineerId,newDomain); 
		  ResponseEntity re=new ResponseEntity<Engineer>(a1,HttpStatus.OK);
		  return re;
	}
	@DeleteMapping("/removeEngineer/{engineerId}")
	public ResponseEntity removeEngineer(@PathVariable int engineerId) throws InvalidEngineerIdException {
		iadmin.removeEngineer(engineerId);
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	@GetMapping("/getComplaintsByProducts/{productCategoryName}")
	public ResponseEntity<List<Engineer>> getComplaintsByProducts(@PathVariable String productCategoryName){
		List<Complaint> le=iadmin.getComplaintsByProducts(productCategoryName);
		  ResponseEntity re=new ResponseEntity<List<Complaint>>(le,HttpStatus.OK);
		  return re;
	}
	
	@GetMapping("/getComplaints/{status}")
	public ResponseEntity<List<Complaint>> getComplaints(@PathVariable String status) {
	List<Complaint> le=iadmin.getComplaints(status);
	  ResponseEntity re=new ResponseEntity<List<Complaint>>(le,HttpStatus.OK);
	  return re;}

//	@PutMapping("/replaceEngineer/{complaintId}")
//	public ResponseEntity<Complaint> replaceEngineerFromComplaint(int complaintId,int engineerId) throws InValidDomainException{
//		Complaint a1=iadmin.replaceEngineerFromComplaint(complaintId, engineerId); 
//		  ResponseEntity re=new ResponseEntity<Complaint>(a1,HttpStatus.OK);
//		  return re;
//	}
//}

	
}