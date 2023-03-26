package com.ed.patterns.basic;

public class Pyramid2Mirror {
	public static void main(String[] args) {

		int row = 5;
		// outer loop
		for (int i = row; i >= 1; i--) {
			// inner loop
			for (int j = 1; j <= row - i; j++) {
				System.out.print(" ");
			}
			// inner loop
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
				try {
					Thread.sleep(250);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println();
		}
	}

}
