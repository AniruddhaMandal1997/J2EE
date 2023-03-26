package com.jspiders.singleton.object;

public class SingletonEger {
	
	static SingletonEger object = new SingletonEger();
	
	private SingletonEger() {
		System.out.println("Constructor accessed");
	}
	
	public static SingletonEger getObject() {
		System.out.println("Method accessed");
		return object;
	}
}
