package com.wcp.ProjectDeliverable.Service;

import java.time.LocalDate;

public class UtilService {
	
	public static LocalDate getDate() {
		LocalDate  localDate  = LocalDate.now();
		System.out.println(localDate);
		return localDate;
	}

}
