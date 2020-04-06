package com.wcp.ProjectDeliverable.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wcp.ProjectDeliverable.Model.EmployeeChangesModel;
import com.wcp.ProjectDeliverable.dom.CRImplDetails;

@Repository
public interface EmployeeChangesRepo extends JpaRepository<EmployeeChangesModel,Integer> {

	/*
	 * @Query(value =
	 * "SELECT new com.wcp.ProjectDeliverable.dom.CRImplDetails(c.cr_number,e.emp_name,e.EMP_DESC) FROM CDM_EMPLOYEE_DETAILS e,CDM_EMPLOYEE_CHANGE_DETAILS c where e.emp_Sso_Id =:empSsoId and c.emp_Sso_Id=e.emp_Sso_Id"
	 * , nativeQuery = true) public List<CRImplDetails>
	 * getCRImplementDetailsOld(@Param("empSsoId") String empSsoId);
	 */
	
	@Query(value = "SELECT new com.wcp.ProjectDeliverable.dom.CRImplDetails(c.cr_Number,e.emp_Name,e.emp_Desc) FROM CDM_EMPLOYEE_CHANGE_DETAILS c ,CDM_EMPLOYEE_DETAILS e where e.emp_Sso_Id =:empSSOId and c.emp_Sso_Id=e.emp_Sso_Id", nativeQuery = true)
	public List<CRImplDetails> getCRImplementDetailsV1(@Param("empSSOId") String empSSOId);
}
