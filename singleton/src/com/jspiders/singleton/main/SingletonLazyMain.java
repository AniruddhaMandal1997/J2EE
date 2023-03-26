package com.jspiders.singleton.main;

import com.jspiders.singleton.object.SingletonLazy;

public class SingletonLazyMain {
	public static void main(String[] args) {
		
		SingletonLazy obj1 = SingletonLazy.getObject();
		SingletonLazy obj2 = SingletonLazy.getObject();
		SingletonLazy obj3 = SingletonLazy.getObject();
		SingletonLazy obj4 = SingletonLazy.getObject();
		
		
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3);
		System.out.println(obj4);
		
	}
}
