package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exceptions.InValidComplaintException;

import com.entities.Complaint;
import com.entities.Engineer;
import com.entities.Product;
import com.service.IComplaintServiceImpl;


import java.util.List;


@RestController
@RequestMapping(path="/api")
public class ComplaintController {
	@Autowired
	IComplaintServiceImpl icomp;
	
	@PostMapping("/bookComplaint")
	public List<Complaint> bookComplaint(@RequestBody List<Complaint> e) {
		List<Complaint> d=icomp.bookComplaint(e);
		return d;
	}
	@PostMapping("/bookComplaints")
	public boolean bookComplaints(@RequestBody Complaint complaint) {
		boolean d=icomp.bookComplaints(complaint);
		return d;
		
	}
	
	  @PutMapping("/updateComplaint/{complaintId}") 
	  public ResponseEntity<String> changeComplaintStatus( @PathVariable int complaintId,@RequestBody String status) throws Throwable { 
		  String a1=icomp.changeComplaintStatus(complaintId,status); 
		  ResponseEntity re=new ResponseEntity<String>(a1,HttpStatus.OK);
		  return re; 
		  }
	  @GetMapping("/getAllComplaint/{clientId}")
	  public ResponseEntity<List<Complaint>> getClientAllComplaints(@PathVariable String clientId){
		  List<Complaint> le=icomp.getClientAllComplaints(clientId);
		  ResponseEntity re=new ResponseEntity<List<Complaint>>(le,HttpStatus.OK);
		  return re;
	  }
	  @GetMapping("/getAllOpenComplaint/{clientId}")
	  public ResponseEntity<List<Complaint>> getClientAllOpenComplaints(@PathVariable String clientId ){
		  List<Complaint> le=icomp.getClientAllOpenComplaints(clientId);
		  ResponseEntity re=new ResponseEntity<List<Complaint>>(le,HttpStatus.OK);
		  return re;
	  }
		
	
	
	  @PostMapping("/saveEngineer")
		public List<Engineer> savesEngineer(@RequestBody List<Engineer> e1) {
			List<Engineer> d=icomp.saveEngineer(e1);
			return d;
		}
		
		
	  @GetMapping("/getEngineer/{complaintId}")
	  public ResponseEntity<Engineer> getEngineer(@PathVariable int complaintId) throws InValidComplaintException {
	  Engineer c1=icomp.getEngineer(complaintId);
	  ResponseEntity re=new ResponseEntity<Engineer>(c1,HttpStatus.OK); 
	  return re;
	  }
			
	  @PostMapping("/saveProduct") 
	  public List<Product> saveProduct(@RequestBody List<Product> e2) { 
		  List<Product> d=icomp.saveProduct(e2); 
	  return d; 
	  }
			  
	 @GetMapping("/getProduct/{complaintId}") 
	 public ResponseEntity<Product> getProductByComplaint(@PathVariable int complaintId) throws InValidComplaintException { 
		 Product c1=icomp.getProductByComplaint(complaintId); 
	     ResponseEntity re=new ResponseEntity<Product>(c1,HttpStatus.OK); 
     	 return re; 
     	 }
			  	
		  
	}

	


