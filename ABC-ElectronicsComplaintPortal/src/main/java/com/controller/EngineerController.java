package com.controller;

import java.time.LocalDate;
import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Complaint;
import com.entities.Engineer;
import com.service.IEngineerService;
import com.service.IEngineerServiceimpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class EngineerController {
	
	@Autowired
	IEngineerServiceimpl engservice;
	
	@PutMapping(path="addEngineer")
	public ResponseEntity<Engineer> addEngineer(@RequestBody Engineer e)
	{
		Engineer ep =engservice.addEngineer(e);
		ResponseEntity re=new ResponseEntity<Engineer>(ep,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getallopencomplaints/{engineerId}")
	public List<Complaint> getAllOpenComplaints1(@PathVariable int engineerId){
		List<Complaint> complaints = engservice.getAllOpenComplaints1(engineerId);
		return complaints;
	}
	
	@GetMapping(path="/resolvedcomplaints/{engineerId}")
	public List<Complaint> getResolvedComplaints1(@PathVariable int engineerId){
		List<Complaint> complaints = engservice.getResolvedComplaints1(engineerId);
		return complaints;
	}

	@GetMapping(path="/getcomplaints/{engineerId}")
	public List<Complaint> getComplaints(@PathVariable int engineerId){
		List<Complaint> complaints = engservice.getComplaints(engineerId);
		return complaints;
	}
	
	@PutMapping(path="/changecomplaintStatus/{complaintId}")
	public String changeComplaintStatus(@PathVariable int complaintId) throws Throwable{
		String str = engservice.changeComplaintStatus(complaintId);
		return str;
	}	
}
