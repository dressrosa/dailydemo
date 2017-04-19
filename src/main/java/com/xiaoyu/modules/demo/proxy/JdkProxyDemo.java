/**
 * 唯有读书,不慵不扰
 */
package com.xiaoyu.modules.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import com.xiaoyu.modules.common.api.DefaultHelloServiceImpl;
import com.xiaoyu.modules.common.api.HelloService;

/**
 * 2017年3月15日下午4:12:10
 * 
 * @author xiaoyu
 * @description jdk原始代理模式
 * @version 1.0
 */
public class JdkProxyDemo {

	public static void main(String args[]) {
		// 正常调用
		System.out.println("-------------------正常调用----------------");
		final HelloService service = new DefaultHelloServiceImpl();
		System.out.println(service.sayHello("xiaoyu"));
		// 接口代理调用
		System.out.println("-------------------接口调用----------------");
		HelloService proxy = (HelloService) Proxy.newProxyInstance(service.getClass().getClassLoader(),
				service.getClass().getInterfaces(), new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("之前...");
						Object result = method.invoke(service, args);
						System.out.println("之后...");
						return result;
					}
				});
		/*
		 * 或者 Proxy.newProxyInstance(HelloService.class.getClassLoader(), new
		 * Class[]{HelloService.class}, h);
		 */
		System.out.println(proxy.sayHello("bigqi"));

		// 类代理 没有实现接口 不能代理 报错
		System.out.println("------------------类调用----------------");
		final JdkProxyDemo demo = new JdkProxyDemo();
		JdkProxyDemo demoProxy = (JdkProxyDemo) Proxy.newProxyInstance(demo.getClass().getClassLoader(),
				demo.getClass().getInterfaces(), new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("之前...");
						Object result = method.invoke(demo, args);
						System.out.println("之后...");
						return result;
					}
				});
		demoProxy.hello();
	}

	public void hello() {
		System.out.println("hello jdkProxy");
	}
}
