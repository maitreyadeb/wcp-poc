package com.wcp.ProjectDeliverable.Service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wcp.ProjectDeliverable.Model.ChangesModel;
import com.wcp.ProjectDeliverable.Model.EmployeeChangesModel;
import com.wcp.ProjectDeliverable.Repository.EmployeeChangesRepo;
import com.wcp.ProjectDeliverable.TransferObject.EmployeeChangesTO;

@Service
public class EmployeeChangesService extends UtilService {
	
	@Autowired
	EmployeeChangesRepo employeeChangesRepo;
	
	@Autowired
	EmployeeChangesModel employeeChangesModel;
	
	@Transactional
	public List<EmployeeChangesModel> saveEmployeeChanges(EmployeeChangesTO employeeChangesTO) {
		List<ChangesModel> crList = employeeChangesTO.getCrNumber();
		List<EmployeeChangesModel> employeeChangesModelList = new ArrayList<EmployeeChangesModel>();
		for (int i =0; i <= crList.size(); i++) {
			this.employeeChangesModel.setEmpSsoId(employeeChangesTO.getEmployeeSsoId().get(0).getEmpSsoId());
			this.employeeChangesModel.setCrNumber(employeeChangesTO.getCrNumber().get(i).getCrNumber());
			employeeChangesModelList.add(i, employeeChangesModel);
		}
		employeeChangesModelList = this.employeeChangesRepo.saveAll(employeeChangesModelList);
		
		return employeeChangesModelList;
	}
	
	
}
