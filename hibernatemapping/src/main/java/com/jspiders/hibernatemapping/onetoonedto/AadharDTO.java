package com.jspiders.hibernatemapping.onetoonedto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class AadharDTO {
	
	@Id
	private int id;
	private long aadhar_no;
	private String issue_date;


}
