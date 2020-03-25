package com.wcp.ProjectDeliverable.Model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
public class ChangesModel {
	
	@Id
	private int idNumber;
	private String crNumber;
	private String brdNumber;
	private String crDescription;
	private String authorName;
	private Date crCreationTime;
	
}
