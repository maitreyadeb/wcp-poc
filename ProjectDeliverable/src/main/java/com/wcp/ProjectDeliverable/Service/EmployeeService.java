package com.wcp.ProjectDeliverable.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wcp.ProjectDeliverable.Model.EmployeeModel;
import com.wcp.ProjectDeliverable.Repository.EmployeeRepository;
import com.wcp.ProjectDeliverable.TransferObject.EmployeeTO;

@Service
public class EmployeeService extends UtilService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeModel employeeModel;

	public EmployeeModel addEmployee(EmployeeTO employeeTO) {
		//employeeModel.setEmpId(employeeTO.getEmpId());
		employeeModel.setEmpDesc(employeeTO.getEmpDesc());
		employeeModel.setEmpName(employeeTO.getEmpName());
		employeeModel.setEmpSsoId(employeeTO.getEmpSsoId());
		employeeModel.setEmpManager(employeeTO.getEmpManager());
		employeeModel.setEmpSupervisorFlag(employeeTO.getEmpSupervisorFlag());
		employeeModel.setCreatedBy("SYSTEM");
		employeeModel.setCreatedDate(this.getDate().toString());
		
		return employeeRepository.save(employeeModel);
		
	}
	public List<EmployeeModel> findEmployeeBySsoId(String ssoId) {		
		return employeeRepository.findByEmployeeSsoId(ssoId);
	}
	
	public List<EmployeeModel> findAllEmployee(){
		return (List<EmployeeModel>) employeeRepository.findAll();
	}
	
	public List<EmployeeModel> findByEmpManager(String loggedUser){
		return (List<EmployeeModel>) employeeRepository.findByEmpManager(loggedUser);
	}
	
}
