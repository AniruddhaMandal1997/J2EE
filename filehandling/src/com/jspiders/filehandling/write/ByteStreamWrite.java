package com.jspiders.filehandling.write;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamWrite {
	public static void main(String[] args) {

		File file = new File("ByteStream.txt");

		if (file.exists()) {
			System.out.println("file already exists");
		} else {
			try {
				file.createNewFile();
				System.out.println("file created");
				
				FileOutputStream fileOutputStream = new FileOutputStream(file);
				fileOutputStream.write(500);
				
				System.out.println("file Written");
				
				fileOutputStream.close();
				
			} catch (IOException e) {
				System.out.println("file not created");
				
			}
		}
	}

}
