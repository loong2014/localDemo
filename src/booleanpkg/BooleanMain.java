package booleanpkg;

import java.util.HashMap;

public class BooleanMain {

	public static class ClassA {

	}

	public static class ClassB {

	}

	public static boolean isHandleA() {
		System.out.println("isHandleA  ");
		return true;
	}

	public static boolean isHandleB() {
		System.out.println("isHandleB  ");
		return true;
	}

	public static void main(String[] args) {
		HashMap<Class, Boolean> stateMap = new HashMap<>();

		stateMap.put(ClassA.class, true);

		Boolean isShow = stateMap.get(ClassB.class);
		System.out.println("is ClassA show :" + isShow);

		// HashMap<String, Boolean> strMap = new HashMap<>();

		// boolean str = strMap.get("aaa"); // 错误
		/*
		 * Exception in thread "main" java.lang.NullPointerException at
		 * booleanpkg.BooleanMain.main(BooleanMain.java:25)
		 */

		// Boolean show = strMap.get("aaa"); // 正确
		// System.out.println("is str show :" + str);

		if (isHandleA() | isHandleB()) {
			System.out.println("1111111");
		}
		
		User user = new User();
		int age = user.getAge();
		System.out.println("age :"+user.getAge());
		int homoe = user.getHome();
		System.out.println("home :"+user.getHome());
		
		
		
	}
}
