package com.jspiders.designpatterntask1.object;

import com.jspiders.designpatterntask1.resource.Account;
import com.jspiders.designpatterntask1.transaction.Transaction;

public class CheckBalance implements Transaction {

	public CheckBalance() {

	}

	@Override
	public void makeTransaction() {
		 int currentBalance = Account.getAccountObject().getAccountBalance();

		System.out.println("Account balance is : " + currentBalance);
		System.out.println("-------------------------------");

	}
}
