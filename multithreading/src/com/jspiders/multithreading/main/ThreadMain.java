package com.jspiders.multithreading.main;

import com.jspiders.multithreading.thread.MyThread1;
import com.jspiders.multithreading.thread.MyThread2;
import com.jspiders.multithreading.thread.MyThread3;

public class ThreadMain {
	public static void main(String[] args) {
//		MyThread1 mythread1 = new MyThread1();
//	
//		MyThread2 mythread2 = new MyThread2();
//		Thread thread = new Thread(mythread2);
//		
//		mythread1.start();
//		thread.start();
		
		MyThread3 mythread = new MyThread3();
		mythread.setName("MyThread3");
		mythread.start();
	}
	

}

