package com.jspiders.singleton.main;

import com.jspiders.singleton.object.SingletonEger;

public class SingletonEgerMain {

	public static void main(String[] args) {
		
		SingletonEger obj1 = SingletonEger.getObject();
		SingletonEger obj2 = SingletonEger.getObject();
		SingletonEger obj3 = SingletonEger.getObject();
		SingletonEger obj4 = SingletonEger.getObject();
		
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);
		System.out.println(obj4);
		
	}
	
}
