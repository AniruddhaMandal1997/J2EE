package com.ed.patterns.basic;

public class SolidRectangle {
	
	public static void main(String[] args) {
		
		int row = 5;
		int col = 6;
		
		//outer loop
		for(int i = 1; i<=row; i++) {
			//inner loop
			for(int j = 1; j<=col; j++) {
				
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
