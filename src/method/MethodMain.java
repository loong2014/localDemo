package method;

import java.lang.reflect.Method;

public class MethodMain {

	private static void showMethodInfo(Method method) {
		System.out.println("method  name :" + method.getName() + " , modifiers :" + method.getModifiers() // 获取方法类型——public/priate...
				+ " , parameterTypes len :" + method.getParameterTypes().length // 获取方法类型——public/priate...
		);
		Class[] types = method.getParameterTypes();
		if (types == null) {
			System.out.println("\tgetParameterTypes is null");
		} else if (types.length < 1) {
			System.out.println("\tgetParameterTypes is empty");
		} else if (types.length == 1) {
			System.out.println("\n\n\n");
			MyAnnotation mAnnotation = method.getAnnotation(MyAnnotation.class);
			System.out.println("\tgetAnnotation  mAnnotation :" + mAnnotation+"  subName :"+mAnnotation.subName());
			for (Class clazz : types) {
				System.out.println("\t\t parameterType name :" + clazz.getName());
			}

			System.out.println("\n\n\n");
		} else {
			for (Class clazz : types) {
				System.out.println("\t\t parameterType name :" + clazz.getName());
			}
		}

	}

	private static void doGetMethods(Class<?> clazz) {
		System.out.println("\ndoGetMethods");

		Method[] methods = clazz.getMethods(); // 当前类和父类的public方法

		if (methods == null) {
			System.out.println("getMethods is null");
		} else if (methods.length < 1) {
			System.out.println("getMethods is empty");
		} else {
			for (Method method : methods) {
				showMethodInfo(method);

			}
		}

	}

	private static void doGetDeclaredMethods(Class<?> clazz) {
		System.out.println("\ndoGetDeclaredMethods");

		Method[] methods = clazz.getDeclaredMethods(); // 当前类的所有方法

		if (methods == null) {
			System.out.println("getDeclaredMethods is null");
		} else if (methods.length < 1) {
			System.out.println("getDeclaredMethods is empty");
		} else {
			for (Method method : methods) {
				System.out.println("method  name :" + method.getName());
			}
		}
	}

	public static void main(String[] args) {

		// MyClass superClass = new MyClass();
		SuperClassB superClass = new SuperClassB();

		Class<?> clazz = superClass.getClass();

		doGetMethods(clazz);
		// doGetDeclaredMethods(clazz);

	}
}
