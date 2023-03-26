package com.jspiders.multithreadingwaitandnotify.shop;

public class Shop {
	int redShirt;
	int blueShirt;
	int greenShirt;
	
	public synchronized void orderShirt(int orderdRedShirt, int orderdBlueShirt, int orderdGreenShirt) {
		System.out.println("Ordering " + orderdRedShirt + "red Shirt, " +orderdBlueShirt+ " Blue Shirt, "+orderdGreenShirt+"Green Shirt" );
		if(orderdRedShirt>redShirt) {
			System.out.println("Order no of red Shirt not available");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else if(orderdBlueShirt>blueShirt){
			System.out.println("Order no of Blue Shirt not available");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else if(orderdGreenShirt>greenShirt) {
			System.out.println("Order no of Green Shirt not available");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		redShirt-=orderdRedShirt;
		blueShirt-=orderdBlueShirt;
		greenShirt-=orderdGreenShirt;
		System.out.println("Order SuccessFull...................!!!!!!!!!");
	}
	public synchronized void orderShirt(int orderdRedShirt, int orderdBlueShirt) {
		System.out.println("Ordering " + orderdRedShirt + "red Shirt, " +orderdBlueShirt+ " Blue Shirt");
		if(orderdRedShirt>redShirt) {
			System.out.println("Order no of red Shirt not available");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else if(orderdBlueShirt>blueShirt){
			System.out.println("Order no of Blue Shirt not available");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		redShirt-=orderdRedShirt;
		blueShirt-=orderdBlueShirt;
		System.out.println("Order SuccessFull...................!!!!!!!!!");
	}
	
	public synchronized void orderShirt(int orderdRedShirt) {
		System.out.println("Ordering " + orderdRedShirt + "red Shirt");
		if(orderdRedShirt>redShirt) {
			System.out.println("Order no of red Shirt not available");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		redShirt-=orderdRedShirt;
		System.out.println("Order SuccessFull...................!!!!!!!!!");
	}
	public synchronized void makeShirt(int makeRedShirt, int makeBlueShirt,int makeGreenShirt) {
		System.out.println("Importing " +makeRedShirt+" red "+makeBlueShirt+" Blue "+makeGreenShirt+" Green Shirt" );
		redShirt+=makeRedShirt;
		blueShirt+=makeBlueShirt;
		greenShirt+=makeGreenShirt;
		System.out.println("Shirt Now Available");
		this.notifyAll();
	}
	
}
