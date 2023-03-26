package com.jspiders.mavenproject1.dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmpFindDTO {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory=Persistence.createEntityManagerFactory("emp");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
		
	}
	 private static void closeConnection() {
		 if(factory != null) {
			 factory.close();
		 }
		 if(manager != null) {
			 manager.clear();
		 }
		 if(transaction.isActive()) {
			 transaction.rollback();
		 }
	 }
	
	 public static void main(String[] args) {
		
		 try {
			 
			openConnection();
			transaction.begin();
			
			EmployeeDTO employee = manager.find(EmployeeDTO.class, 3) ;
			System.out.println(employee);
			
			transaction.commit();
			
		} finally {
			closeConnection();
		}
	}
}
