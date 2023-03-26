package com.jspiders.designpatterntask1.object;

import com.jspiders.designpatterntask1.resource.Account;
import com.jspiders.designpatterntask1.transaction.Transaction;

public class Withdraw implements Transaction {

	int withdrawAmount;

	public Withdraw(int withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

	@Override
	public void makeTransaction() {

 
		if (Account.getAccountObject().getAccountBalance() < withdrawAmount) {
			System.out.println("Insufficiant Fund");
		} else {
			int newBalance = Account.getAccountObject().getAccountBalance() - withdrawAmount;
			Account.getAccountObject().setWithdrawAmount(newBalance);
			System.out.println(withdrawAmount + " amount Withdrawal successful....!!!!");
			System.out.println("Current Balance is : " + Account.getAccountObject().getAccountBalance());
			System.out.println("-------------------------------");
		}

	}
}
