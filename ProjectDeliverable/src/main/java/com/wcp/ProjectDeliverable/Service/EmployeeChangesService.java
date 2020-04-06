package com.wcp.ProjectDeliverable.Service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.wcp.ProjectDeliverable.Model.ChangesModel;
import com.wcp.ProjectDeliverable.Model.EmployeeChangesModel;
import com.wcp.ProjectDeliverable.Repository.EmployeeChangesRepo;
import com.wcp.ProjectDeliverable.TransferObject.EmployeeChangesTO;
import com.wcp.ProjectDeliverable.dom.CRImplDetails;

@Service
public class EmployeeChangesService extends UtilService {

	@Autowired
	EmployeeChangesRepo employeeChangesRepo;

	@Autowired
	EmployeeChangesModel employeeChangesModel;

	@Autowired
	EntityManagerFactory emf;

	@Transactional
	public List<EmployeeChangesModel> saveEmployeeChanges(EmployeeChangesTO employeeChangesTO) {
		List<ChangesModel> crList = employeeChangesTO.getCrNumber();
		List<EmployeeChangesModel> employeeChangesModelList = new ArrayList<EmployeeChangesModel>();
		for (int i = 0; i <= crList.size(); i++) {
			this.employeeChangesModel.setEmpSsoId(employeeChangesTO.getEmployeeSsoId().get(0).getEmpSsoId());
			this.employeeChangesModel.setCrNumber(employeeChangesTO.getCrNumber().get(i).getCrNumber());
			employeeChangesModelList.add(i, employeeChangesModel);
		}
		employeeChangesModelList = this.employeeChangesRepo.saveAll(employeeChangesModelList);

		return employeeChangesModelList;
	}

	public List<CRImplDetails> getCRImplDetailsV1(String empSSOId) {

		List<CRImplDetails> listCRImplDetails = null;
		listCRImplDetails = this.employeeChangesRepo.getCRImplementDetailsV1(empSSOId);
		System.out.println(listCRImplDetails);
		return listCRImplDetails;
	}

	public List<CRImplDetails> getCRImplDetailsV2(String empSSOId) {
		EntityManager em = emf.createEntityManager();
		// em.getTransaction().begin( );

		Query query = em.createQuery("Select c.crNumber,e.empName,e.empDesc from"
				+ " EmployeeChangesModel c ,EmployeeModel e"
				+ " where c.empSsoId=e.empSsoId and e.empSsoId =:empSSOId");

		query.setParameter("empSSOId", empSSOId);
		System.out.println(query.getResultList());
		@SuppressWarnings("unchecked")
		List<CRImplDetails> list = (List<CRImplDetails>) query.getResultList();
		em.close();

		return list;
	}
}
