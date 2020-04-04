package com.wcp.ProjectDeliverable.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
@Table(name="CDM_EMPLOYEE_CHANGE_DETAILS")
@Getter@Setter@NoArgsConstructor
public class EmployeeChangesModel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int employeeChangeId;
	private String empSsoId;
	private String crNumber;

}
