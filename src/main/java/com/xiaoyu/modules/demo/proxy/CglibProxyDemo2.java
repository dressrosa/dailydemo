package com.xiaoyu.modules.demo.proxy;

import java.lang.reflect.Method;

import com.xiaoyu.modules.common.api.DefaultHelloServiceImpl;
import com.xiaoyu.modules.common.api.HelloService;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 2017年3月15日下午4:36:12
 * 
 * @author xiaoyu
 * @description cglib代理 上个例子写的不好,被代理的类不应该会和cglib耦合
 * @version 1.0
 */
public class CglibProxyDemo2 {

	public static void main(String[] args) {
		Enhancer hancer = new Enhancer();
		hancer.setSuperclass(DefaultHelloServiceImpl.class);
		hancer.setCallback(new MethodInterceptor() {
			// 这样就没啥耦合了 只要指定要代理的类就行了
			@Override
			public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
				System.out.println("before");
				Object result = proxy.invokeSuper(obj, args);
				System.out.println("after");
				return result;
			}
		});
		HelloService demo = (HelloService) hancer.create();
		demo.sayHello("xiaoyu");
	}

}
