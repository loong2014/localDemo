package reflection;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionMain {

	public static void logD(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) {

		logD("main --- start");

		ClassLoader classLoader = ClassLoader.getSystemClassLoader();

		// java.lang.ClassLoader cl = getClassLoader();
		// service = (Service) cl.loadClass(data.info.name).newInstance();

		Class userBeanClass = null;
		try {
			// userBeanClass =UserBean.class; // 1 方式一，直接获取
			userBeanClass = classLoader.loadClass("reflection.UserBean"); // 2
																			// 方式二，根据类路径
		} catch (ClassNotFoundException e) {
			logD("loadClass error :" + e.toString());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logD("\n\n打印项目class信息");
		showClassInfo(userBeanClass);

		logD("\n\n测试自定义ClassLoader");
		testClassLoadler();

	}

	private static void showClassInfo(Class clazz) {
		if (clazz == null) {
			logD("showClassInfo  clazz is null");
			return;
		}

		logD("\n打印成员变量信息——getDeclaredFields");
		Field[] fields = clazz.getDeclaredFields();
		logD("fields :" + fields.length);

		logD("修饰符 : 变量类型 : 变量名称");
		for (Field field : fields) {
			logD(Modifier.toString(field.getModifiers()) + " : " + field.getType() + " : " + field.getName());
		}

		logD("\n打印成员方法信息——getDeclaredMethods");
		Method[] methods = clazz.getDeclaredMethods();
		logD("methods :" + methods.length);

		logD("修饰符 : 返回类型 : 方法名称 : (参数)");
		for (Method method : methods) {
			String str = Modifier.toString(method.getModifiers()) + " : " + method.getReturnType() + " : "
					+ method.getName();
			str = str + "(";

			Class[] parameters = method.getParameterTypes();
			for (Class parameter : parameters) {
				str = str + "\n\t" + parameter.getTypeName();
			}

			str = str + ")";
			logD(str);
		}

		logD("\n打印构造函数——getDeclaredConstructors");
		Constructor[] constructors = clazz.getDeclaredConstructors();
		logD("constructors :" + constructors.length);

		logD("修饰符 : 方法名称 : (参数)");
		for (Constructor constructor : constructors) {
			String str = Modifier.toString(constructor.getModifiers()) + " : " + constructor.getName();
			str = str + "(";

			Class[] parameters = constructor.getParameterTypes();
			for (Class parameter : parameters) {
				str = str + "\n\t" + parameter.getTypeName();
			}

			str = str + ")";
			logD(str);
		}
	}

	private static void testClassLoadler() {
		
		// 这里的类名，必须与编写LocalInfo文件时，文件的引用路径一致
		String filePath = "com.sunny.LocalInfo";
		
		ClassLoader classLoader = new MyClassLoadler();
		Class clazz = null;
		try {
			clazz = classLoader.loadClass(filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}

		showClassInfo(clazz);
	}
	
	
}
