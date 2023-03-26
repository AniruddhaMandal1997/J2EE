package com.jspiders.designpatterntask1.object;

import com.jspiders.designpatterntask1.resource.Account;
import com.jspiders.designpatterntask1.transaction.Transaction;

public class Deposite implements Transaction {

	int depositeAmount;

	public Deposite(int depositeAmount) {
		this.depositeAmount = depositeAmount;
	}

	@Override
	public void makeTransaction() {
		

		int newBalance = Account.getAccountObject().getAccountBalance() + depositeAmount;
		Account.getAccountObject().setDepositeAmount(newBalance);
		System.out.println(depositeAmount + " amount Deposite successful.....!!!!!!!!!!");

		System.out.println("Current Balance is : " + Account.getAccountObject().getAccountBalance());
		System.out.println("-------------------------------");
	}

}
