package com.jspiders.classtask;

import java.util.Scanner;

public class Task1 {
	public static void main(String[] args) {
		
		int matrixA[][] = {{1,2,3},{4,5,6},{7,8,9}};
		int matrixB[][] = {{1,2,3},{4,5,6},{7,8,9}};
		int [][] resultMatrix = new int [3][3]; 
	
		for(int i=0;i<=2;i++) {
			for(int j=0;j<=2;j++) {
				resultMatrix[i][j] =matrixA[i][j] + matrixB[i][j];
				System.out.print("  "+ resultMatrix[i][j]);
			}
			System.out.println();
			
		}
		Scanner s = new Scanner(System.in);
		System.out.println("Enter row num");
		int row = s.nextInt();
		System.out.println("Enter column num");
		int column = s.nextInt();
		System.out.println(resultMatrix[row][column]);
	}
}
