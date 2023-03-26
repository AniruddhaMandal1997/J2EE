package com.ed.patterns.basic;

public class Rectangle {
	
	public static void main(String[] args) {
		
		int row = 5;
		int col = 7;
		
		//outer loop
		for(int i=1;i<=row;i++) {
			//inner loop
			for(int j=1;j<=col;j++) {
				
				if(i==row || j== col || i == 1 || j == 1) {
					System.out.print(" *");
				}
				else {
					System.out.print("  ");
				}
				
			}
			System.out.println();
		}
	}

}
