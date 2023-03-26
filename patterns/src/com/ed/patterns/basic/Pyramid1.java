package com.ed.patterns.basic;

public class Pyramid1 {

	public static void main(String[] args) {

		int row = 35;
//		int col = 6;

		// outer loop
		for (int i = 1; i <= row; i++) {
			// Inner Loop
			for (int j = 1; j <= i; j++) {

				System.out.print("*");
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println();
		}

	}

}
