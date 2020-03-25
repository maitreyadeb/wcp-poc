package com.wcp.ProjectDeliverable.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wcp.ProjectDeliverable.Service.ChangeService;
import com.wcp.ProjectDeliverable.TransferObject.ChangesTO;

@RestController
public class ProjectDeliverableController {
	
	@Autowired
	ChangeService changeService;
	
	@GetMapping("/addChanges")
	public void addChanges() {
		System.out.println("Inside addChanges........");
	}
	
	@PostMapping("/addChanges")
	public void addChanges(@RequestBody ChangesTO changesTo) {
		System.out.println("Inside addChanges........");
		
		this.changeService.addChanges(changesTo);
		
		System.out.println(changesTo.toString());
	}
	
	
	

}
