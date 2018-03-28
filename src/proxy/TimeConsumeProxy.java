package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 实现 InvocationHandler 接口，使自己称为一个代理者
public class TimeConsumeProxy implements InvocationHandler {

	private Object realObject;

	/**
	 * 将功能实现者转换成一个代理类
	 */
	public Object binder(Object obj) {
		this.realObject = obj; // 功能实现者
		// 通过Proxy工具，把实现类转换成一个代理类
		System.out.println("interface :"+obj.getClass().getInterfaces().getClass().getName());
		
		Object proxyObject = Proxy.newProxyInstance(
				obj.getClass().getClassLoader(), // 类加载器
				obj.getClass().getInterfaces(), // 功能接口
				this // 功能代理者
		);
		return proxyObject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 这里可以做一下AOP操作，比如方法耗时，调用方法的前提判断等
		return method.invoke(this.realObject, args);
	}
}


