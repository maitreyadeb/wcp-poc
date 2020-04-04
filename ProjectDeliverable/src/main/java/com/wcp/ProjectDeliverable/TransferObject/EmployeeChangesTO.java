package com.wcp.ProjectDeliverable.TransferObject;

import java.util.List;

import com.wcp.ProjectDeliverable.Model.ChangesModel;
import com.wcp.ProjectDeliverable.Model.EmployeeModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@NoArgsConstructor
@ToString
public class EmployeeChangesTO {
	
	private List<EmployeeModel> employeeSsoId;
	private List<ChangesModel> crNumber;
	private String updateMessage;

}
