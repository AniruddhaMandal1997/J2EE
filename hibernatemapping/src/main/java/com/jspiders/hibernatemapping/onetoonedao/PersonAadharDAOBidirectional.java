package com.jspiders.hibernatemapping.onetoonedao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.hibernatemapping.onetoonedto.AadharDTOBi;
import com.jspiders.hibernatemapping.onetoonedto.PersonDTOBi;

public class PersonAadharDAOBidirectional {
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

			PersonDTOBi person = new PersonDTOBi();
			person.setId(1);
			person.setName("Aniruddha");
			person.setContact(9123899251l);
			person.setCity("kolkata");

			AadharDTOBi aadhar = new AadharDTOBi();
			aadhar.setId(1);
			aadhar.setAadhar_no(123456789123l);
			aadhar.setIssue_date("12-NOV-2012");

			person.setAadhar(aadhar);
			aadhar.setPerson(person);

			manager.persist(aadhar);
			manager.persist(person);

			transaction.commit();
		} finally {
			closeConnection();
		}
	}
}
