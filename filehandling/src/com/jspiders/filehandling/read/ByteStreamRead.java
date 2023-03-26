package com.jspiders.filehandling.read;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteStreamRead {
	public static void main(String[] args) {

		File file = new File("ByteStream.txt");

		if (file.exists()) {
			try {
				FileInputStream fileInputStream = new FileInputStream(file);

				System.out.println("read() method output : " + fileInputStream.read());

				fileInputStream.close();

			} catch (FileNotFoundException e) {
				System.out.println("file not found");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
