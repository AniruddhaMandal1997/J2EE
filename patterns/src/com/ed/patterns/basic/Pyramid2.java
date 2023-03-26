package com.ed.patterns.basic;

public class Pyramid2 {
	public static void main(String[] args) {

		int row = 5;
		// outer loop
		for (int i = row; i >= 1; i--) {
			// inner loop
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
