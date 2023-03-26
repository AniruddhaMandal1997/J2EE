package com.jspiders.adapterpattern.adapter;

import com.jspiders.adapterpattern.Interface.Events;
import com.jspiders.adapterpattern.object.Employe;

public class EmpEventAdapter extends Employe implements Events {

	@Override
	public void fathersDay() {
		EmpEventAdapter employe1 = new EmpEventAdapter();
		employe1.setEmp_id(1);
		employe1.setEmp_name("Akash");
		
		System.out.println("employe name is : "+employe1.getEmp_name());
		
	}

	@Override
	public void mothersDay() {
		
		EmpEventAdapter employe2 = new EmpEventAdapter();
		employe2.setEmp_id(2);
		employe2.setEmp_name("Abhishek");
		
		System.out.println("employe name is : " + employe2.getEmp_name());
	}
	
	public static void main(String[] args) {
		EmpEventAdapter adapter = new EmpEventAdapter();
		adapter.fathersDay();
		adapter.mothersDay();
	}

}
