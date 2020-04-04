package com.wcp.ProjectDeliverable.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wcp.ProjectDeliverable.Model.ChangesModel;
import com.wcp.ProjectDeliverable.Model.EmployeeModel;

public interface EmployeeRepository extends CrudRepository<EmployeeModel,Integer> {

	@Query(value = "SELECT * from CDM_EMPLOYEE_DETAILS e where e.emp_Sso_Id =:empSsoId ", nativeQuery = true)  
	List<EmployeeModel> findByEmployeeSsoId(@Param("empSsoId") String empSsoId); 
	
	List<EmployeeModel> findByEmpManager(String loggedUser);
}
