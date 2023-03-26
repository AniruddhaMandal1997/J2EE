package com.jspiders.multithreadingwaitandnotify.main;

import java.io.File;

import com.jspiders.multithreadingwaitandnotify.customer.Customer;
import com.jspiders.multithreadingwaitandnotify.manufacturer.Manufacturer;
import com.jspiders.multithreadingwaitandnotify.shop.Shop;

public class Main {
	public static void main(String[] args) {
		Shop shop = new Shop();
		
		Customer customers = new Customer(shop);
		Manufacturer manufacturer = new Manufacturer(shop);
		
		customers.start();
		manufacturer.start();
	}
}
