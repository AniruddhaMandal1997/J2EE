package com.jspiders.multithreadingwaitandnotify.customer;

import java.util.Scanner;

import com.jspiders.multithreadingwaitandnotify.shop.Shop;

public class Customer extends Thread {
	private Shop shop;

	public Customer(Shop shop) {
		this.shop = shop;
	}

	public void run() {
		shop.orderShirt(10, 20, 10);
		shop.orderShirt(20, 20);
		shop.orderShirt(60);
	}
}
