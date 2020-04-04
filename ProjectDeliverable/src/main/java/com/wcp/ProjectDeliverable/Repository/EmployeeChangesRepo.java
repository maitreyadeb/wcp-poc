package com.wcp.ProjectDeliverable.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcp.ProjectDeliverable.Model.EmployeeChangesModel;

@Repository
public interface EmployeeChangesRepo extends JpaRepository<EmployeeChangesModel,Integer> {

}
