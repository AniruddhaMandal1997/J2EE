package com.jspiders.hibernatemapping.onetoonedto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class PersonDTOBi {

	@Id
	private int id;
	private String name;
	private String city;
	private long contact;

	@OneToOne
	private AadharDTOBi aadhar;

}
