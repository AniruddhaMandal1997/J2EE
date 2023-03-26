package com.jspiders.filehandling.read;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CharStreamRead {
	public static void main(String[] args) {
		File file = new File("CharStream.txt");
		
		 if (file.exists()) {
			try {
				FileReader fileReader = new FileReader(file);
				System.out.println("fileReader.read() output : " + fileReader.read());
				
				Scanner scanner = new Scanner(file);
				
				while (scanner.hasNextLine()) {
					System.out.println(scanner.nextLine()); 	
				}
				scanner.close();
				fileReader.close();
				
			} catch (IOException e) {
				System.out.println("file not found");
			}
		} else {
			System.out.println("file not exist");
		}
	}
	
}
