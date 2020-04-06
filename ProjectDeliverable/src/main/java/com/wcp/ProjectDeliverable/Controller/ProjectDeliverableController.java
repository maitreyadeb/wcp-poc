package com.wcp.ProjectDeliverable.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wcp.ProjectDeliverable.Exception.NotFoundException;
import com.wcp.ProjectDeliverable.Model.ChangesModel;
import com.wcp.ProjectDeliverable.Model.EmployeeChangesModel;
import com.wcp.ProjectDeliverable.Model.EmployeeModel;
import com.wcp.ProjectDeliverable.Service.ChangeService;
import com.wcp.ProjectDeliverable.Service.EmployeeChangesService;
import com.wcp.ProjectDeliverable.Service.EmployeeService;
import com.wcp.ProjectDeliverable.TransferObject.ChangesTO;
import com.wcp.ProjectDeliverable.TransferObject.EmployeeChangesTO;
import com.wcp.ProjectDeliverable.TransferObject.EmployeeTO;
import com.wcp.ProjectDeliverable.dom.CRImplDetails;

@RestController
public class ProjectDeliverableController {
	
	@Autowired
	ChangeService changeService;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	EmployeeChangesService employeeChangesService;
	
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
	public ResponseEntity<Object> addChanges(@Valid @RequestBody ChangesTO changesTo) {
		System.out.println("Inside addChanges..POST......");
		this.changeService.addChanges(changesTo);
		System.out.println(changesTo.toString());
		return new ResponseEntity<Object>(HttpStatus.CREATED); 	
	}
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Object> addEmployee(@RequestBody EmployeeTO employeeTO) {
		
		this.employeeService.addEmployee(employeeTO);
		return new ResponseEntity<Object>(HttpStatus.CREATED); 	
	}
	
	@GetMapping("/findEmployee/{ssoId}")
	public ResponseEntity<Object> findEmployee(@PathVariable String ssoId) {
		List<EmployeeModel> employeeModels = this.employeeService.findEmployeeBySsoId(ssoId);
		return new ResponseEntity<Object>(employeeModels, HttpStatus.FOUND);
	}
	
	@GetMapping("/findAllEmployee")
	public ResponseEntity<Object> findAllEmployee() {
		List<EmployeeModel> employeeModels = this.employeeService.findAllEmployee();
		return new ResponseEntity<Object>(employeeModels, HttpStatus.FOUND);
	}
	
	@GetMapping("/getEmployeeChangesDetails")
	public ResponseEntity<Object> onLoadEmployeeChangesDetails(){
		///Fetch loggedUser//session needs to be implemented 
		String loggedUser = "503001640";
		EmployeeChangesTO employeeChangesTO = new EmployeeChangesTO();
		List<EmployeeModel> employeeModels = this.employeeService.findEmployeeBySsoId(loggedUser);
		List<ChangesModel>  allCRDetails = this.changeService.searchAllChanges();
		employeeChangesTO.setCrNumber(allCRDetails);
		if(!employeeModels.isEmpty()) {
			if(employeeModels.get(0).getEmpSupervisorFlag().equalsIgnoreCase("Y")) {	///set EmpSupervisorFlag as Y for Managers
				List<EmployeeModel> employeesUnderManager = this.employeeService.findByEmpManager(loggedUser);
				employeeChangesTO.setEmployeeSsoId(employeesUnderManager);
			}else {
				List<EmployeeModel> employeeSsoId = new ArrayList<EmployeeModel>();
				EmployeeModel employeeModel = new EmployeeModel(loggedUser);
				employeeSsoId.add(employeeModel);
				employeeChangesTO.setEmployeeSsoId(employeeSsoId);
			}	
		}else {
			throw new NotFoundException("Employee not found.....");
		}
		return new ResponseEntity<Object>(employeeChangesTO, HttpStatus.FOUND);	
	}
	
	@PostMapping("/postEmployeeChangesDetails")
	public ResponseEntity<Object> onSubmitEmployeeChangesDetails(@RequestBody EmployeeChangesTO employeeChangesTO){
		List<EmployeeChangesModel> employeeChangesDetails = this.employeeChangesService.saveEmployeeChanges(employeeChangesTO);
		return new ResponseEntity<Object>(employeeChangesDetails, HttpStatus.CREATED);
	}

	@GetMapping("/findCRImplementDetails/{ssoId}")
	public ResponseEntity<Object> findCRImplementDetails(@PathVariable String ssoId) {
		System.out.println("SSO ID "+ssoId);
		/* Working fine with V2 
			List<CRImplDetails> changesImplDetails = this.employeeChangesService.getCRImplDetailsV2(ssoId);
		*/
		List<CRImplDetails> changesImplDetails = this.employeeChangesService.getCRImplDetailsV1(ssoId);
		return new ResponseEntity<Object>(changesImplDetails, HttpStatus.FOUND);
	}
}
