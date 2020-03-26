package com.wcp.ProjectDeliverable.Exception;

import java.util.Date;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter@Setter@NoArgsConstructor@ToString
public class ExceptionResponse {
	private Date timestamp;
	private String message;
	private String details;
}
