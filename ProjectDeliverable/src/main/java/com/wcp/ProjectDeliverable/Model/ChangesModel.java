package com.wcp.ProjectDeliverable.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
@Table(name="CDM_CHANGE_DETAILS")
@Getter@Setter@NoArgsConstructor
public class ChangesModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int idNumber;
	@Column(name="CR_NUMBER", length=50, nullable=false, unique=true)
	private String crNumber;
	private String brdNumber;
	private String crDescription;
	private String authorName;
	private String crCreationTime;
	@Temporal(TemporalType.DATE)
	private Date crProductionMoveDate;
	private String crBase64;
	private String brdBase64;
	
}
