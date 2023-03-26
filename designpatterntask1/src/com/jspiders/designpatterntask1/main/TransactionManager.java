package com.jspiders.designpatterntask1.main;

import java.util.Scanner;

import com.jspiders.designpatterntask1.object.CheckBalance;
import com.jspiders.designpatterntask1.object.Deposite;
import com.jspiders.designpatterntask1.object.Withdraw;
import com.jspiders.designpatterntask1.transaction.Transaction;

public class TransactionManager {
	static Transaction transaction = null;
	static boolean loop = true;

	public static void main(String[] args) {
		while (loop) {

			try {
				execute().makeTransaction();
			} catch (Exception e) {
				System.out.println("");;
			}
		}

	}

	private static Transaction execute() {
		System.out.println("_____WELCOME_____");
		System.out.println("1. Diposite amount\n" + "2. Withdwaw amount\n" + "3. Check balance\n" + "4. Exit");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();

		switch (choose) {
		case 1:
			System.out.println("Enter amount to Deposite");
			int depositeAmount = sc.nextInt();
			transaction = new Deposite(depositeAmount);
			return transaction;
		case 2:
			System.out.println("Enter amount to withdraw ");
			int withdrawAmount = sc.nextInt();
			transaction = new Withdraw(withdrawAmount);
			return transaction;
		case 3:
			transaction = new CheckBalance();
			return transaction;
		case 4:
			loop = false;
			sc.close();
			return transaction;
		default:
			System.out.println("Invalid input");
			return transaction;
		}

	}

}
