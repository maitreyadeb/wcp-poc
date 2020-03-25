package com.wcp.ProjectDeliverable.TransferObject;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@NoArgsConstructor
@ToString
public class ChangesTO {
	
	private String crNumber;
	private String brdNumber;
	private String crDescription;
	private String authorName;
	
}
