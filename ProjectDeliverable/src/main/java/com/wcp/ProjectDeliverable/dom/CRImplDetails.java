package com.wcp.ProjectDeliverable.dom;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data@NoArgsConstructor
@ToString
public class CRImplDetails {
	private String crNumber;
	private String empName;
	private String empDesc;
	
	public CRImplDetails(String crNumber, String empName, String empDesc) {
		super();
		this.crNumber = crNumber;
		this.empName = empName;
		this.empDesc = empDesc;
	}

	
}
