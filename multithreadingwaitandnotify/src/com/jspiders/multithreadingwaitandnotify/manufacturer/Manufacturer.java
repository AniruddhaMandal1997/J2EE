package com.jspiders.multithreadingwaitandnotify.manufacturer;

import com.jspiders.multithreadingwaitandnotify.shop.Shop;

public class Manufacturer extends Thread {
	private Shop shop;
	
	public Manufacturer(Shop shop) {
		this.shop=shop;
	}
	
	public void run() {
		shop.makeShirt(50, 50, 50);
	}
}
