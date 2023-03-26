package com.jspiders.factory.main;

import java.util.Scanner;
import com.jspiders.factory.beverage.Beverage;
import com.jspiders.factory.object.BlackTea;
import com.jspiders.factory.object.GingerTea;
import com.jspiders.factory.object.MasalaTea;
import com.jspiders.factory.object.RedTea;

public class FactoryMain {

	static Beverage tea;

	public static void main(String[] args) {
		try {
			factory().order();
		} catch (NullPointerException e) {
			System.out.println("Tea not ordered");
		}
	}

	private static Beverage factory() {
		System.out.println("1. Red Tea\n" + "2. Masala Tea\n" + "3. Black Tea\n" + "4. Ginger tea");
		Scanner choose = new Scanner(System.in);
		int option = choose.nextInt();
		choose.close();

		switch (option) {
		case 1:
			tea = new RedTea();
			return tea;
		case 2:
			tea = new MasalaTea();
			return tea;
		case 3:
			tea = new BlackTea();
			return tea;
		case 4:
			tea = new GingerTea();
			return tea;
		default:
			System.out.println("Invalid input");
			return tea;
		}
	}
}
