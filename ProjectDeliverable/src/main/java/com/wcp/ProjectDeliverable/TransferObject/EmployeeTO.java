package com.wcp.ProjectDeliverable.TransferObject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@NoArgsConstructor
@ToString
public class EmployeeTO {
	
	//private int empId;
	private String empSsoId;
	private String empName;
	private String empDesc;
	private String empManager;
	private String empSupervisorFlag;

}
