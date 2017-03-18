package com.xiaoyu.modules.demo.proxy;

import java.lang.reflect.Method;
import com.xiaoyu.modules.common.api.DefaultHelloServiceImpl;
import com.xiaoyu.modules.common.api.HelloService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.Proxy;

/**
 * 2017年3月15日下午4:36:12
 * 
 * @author xiaoyu
 * @description cglib代理 可以代理接口和类 类代理需要实现MethodInterceptor 接口无所谓
 * @version 1.0
 */
public class CglibProxyDemo implements MethodInterceptor {

	public static void main(String[] args) {
		// 正常调用
		System.out.println("-------------------正常调用----------------");
		final HelloService service = new DefaultHelloServiceImpl();
		System.out.println(service.sayHello("xiaoyu"));
		// 接口代理调用
		System.out.println("-------------------接口代理调用----------------");
		HelloService proxy1 = (HelloService) Proxy.newProxyInstance(service.getClass().getClassLoader(),
				service.getClass().getInterfaces(), new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("之前");
						Object result = method.invoke(service, args);
						System.out.println("之后");
						return result;
					}
				});
		System.out.println(proxy1.sayHello("bigqi1"));
		// 类代理调用
		System.out.println("-------------------类代理调用----------------");
		CglibProxyDemo demo = new CglibProxyDemo();
		CglibProxyDemo proxy = CglibProxyDemo.getProxy(demo);
		proxy.hello();
	}

	public void hello() {
		System.out.println("hello jdkProxy");
	}

	private static CglibProxyDemo getProxy(CglibProxyDemo demo) {
		Enhancer hancer = new Enhancer();
		hancer.setSuperclass(demo.getClass());
		hancer.setCallback(demo);
		return (CglibProxyDemo) hancer.create();
	}

	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("之前...");
		proxy.invokeSuper(obj, args);
		System.out.println("之后...");
		return null;
	}
}
