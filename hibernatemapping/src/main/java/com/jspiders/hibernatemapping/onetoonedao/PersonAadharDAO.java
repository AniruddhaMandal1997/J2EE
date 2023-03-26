package com.jspiders.hibernatemapping.onetoonedao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernatemapping.onetoonedto.AadharDTO;
import com.jspiders.hibernatemapping.onetoonedto.PersonDTO;

public class PersonAadharDAO {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		
		factory = Persistence.createEntityManagerFactory("aadhar");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		
	}
	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}
	
	public static void main(String[] args) {
		try {
			openConnection();
			
			transaction.begin();
			
			AadharDTO aadhar = new AadharDTO();
			aadhar.setId(1);
			aadhar.setAadhar_no(123456789123l);
			aadhar.setIssue_date("12-NOV-2012");
			
			manager.persist(aadhar);
			
			PersonDTO person = new PersonDTO();
			person.setId(1);
			person.setName("Aniruddha");
			person.setContact(9123899251l);
			person.setCity("kolkata");
			person.setAadhar(aadhar);
			
			manager.persist(person);
			
			transaction.commit();
		} finally {
			closeConnection();
		}
	}
}
