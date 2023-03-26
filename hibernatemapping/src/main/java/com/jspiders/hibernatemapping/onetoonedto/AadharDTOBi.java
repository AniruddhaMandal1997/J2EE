package com.jspiders.hibernatemapping.onetoonedto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class AadharDTOBi {
	@Id
	private int id;
	private long aadhar_no;
	private String issue_date;

	@OneToOne
	private PersonDTOBi person;

}
