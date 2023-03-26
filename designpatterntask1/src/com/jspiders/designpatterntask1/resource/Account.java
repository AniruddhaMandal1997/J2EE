package com.jspiders.designpatterntask1.resource;

public class Account {
	
	private int accountBalance = 10000;
	private static Account account = new Account();
	
	private Account() {
		
	}
	
	
	public int getAccountBalance() {
		return accountBalance;
	}

	public void setDepositeAmount(int amount) {
		this.accountBalance = amount;
	}
	public void setWithdrawAmount(int amount) {
		this.accountBalance = amount;
	}



	public static Account getAccountObject() {
		return account;
	}
	
}
