package reflection;

public class UserBean {
	public String userName;

	private long userId;

	public UserBean(String userName, long userId) {
		this.userName = userName;
		this.userId = userId;
	}

	public String getName() {
		return userName;
	}

	public long getId() {
		return userId;
	}

	public String getInfo(String name, long age) {
		return name + "" + age;
	}

	public static void staticMethod(String devName) {
		System.out.printf("Hi %s, I'm a static method", devName);
	}

	public void publicMethod() {
		System.out.println("I'm a public method");
	}

	private void privateMethod() {
		System.out.println("I'm a private method");
	}

}
