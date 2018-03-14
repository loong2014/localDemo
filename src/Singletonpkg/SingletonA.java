package Singletonpkg;

public class SingletonA {

	private static String kkk = "ddd";

	public class SingletonHolder {
		SingletonA INSTANCE = new SingletonA();

		String getName() {
			return kkk;
		}
	}

	public SingletonA() {
		System.out.println("SingletonA  :" + this);
	}

	public static SingletonA getInstalce() {
		System.out.println("getInstalce");
		// return SingletonHolder.INSTANCE;
		return null;
	}

	public class InnerClass {
		public InnerClass() {
			System.out.println("InnerClass : " + this);
		}
	}

	public static class StaticInnerClass {
		public StaticInnerClass() {
			System.out.println("StaticInnerClass : " + this);
		}
	}

}
