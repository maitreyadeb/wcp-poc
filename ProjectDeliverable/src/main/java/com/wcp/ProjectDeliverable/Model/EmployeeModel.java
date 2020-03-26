package com.wcp.ProjectDeliverable.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
@Table(name="CDM_EMPLOYEE_DETAILS")
@Getter@Setter@NoArgsConstructor
public class EmployeeModel {
	@Id
	private int empId;
	private String empSsoId;
	private String empName;
	private String empDesc;
	private String empManager;
	private String empSupervisor;
	private String createdDate;
	private String updatedDate;
	private String createdBy;
	private String updatedBy;
	
}
