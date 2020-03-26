package com.wcp.ProjectDeliverable.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wcp.ProjectDeliverable.Exception.NotFoundException;
import com.wcp.ProjectDeliverable.Model.ChangesModel;
import com.wcp.ProjectDeliverable.Service.ChangeService;
import com.wcp.ProjectDeliverable.TransferObject.ChangesTO;

@RestController
public class ProjectDeliverableController {
	
	@Autowired
	ChangeService changeService;
	
	@PostMapping("/searchChanges")
	public ResponseEntity<Object> searchChanges(@RequestBody ChangesTO changesTo) {
		System.out.println("Inside searchChanges..GET......");
		List<ChangesModel> changesList = this.changeService.searchChanges(changesTo);
		if(0 == changesList.size()) {
			throw new NotFoundException("CR not found.....");
		}
		return new ResponseEntity<Object>(changesList, HttpStatus.FOUND);
	}
	
	@PostMapping("/addChanges")
	public ResponseEntity<Object> addChanges(@RequestBody ChangesTO changesTo) {
		System.out.println("Inside addChanges..POST......");
		this.changeService.addChanges(changesTo);
		System.out.println(changesTo.toString());
		return new ResponseEntity<Object>(HttpStatus.CREATED); 	
	}
	
	
	

}
