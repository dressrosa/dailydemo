package com.xiaoyu.modules.demo.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.xiaoyu.modules.common.api.HelloService;

/**
 * 2017年3月15日下午3:43:45
 * 
 * @author xiaoyu
 * @description spi模式可以实现代码插拔 需在 META-INF下面建立Serivces文件夹
 *              然后建立一个以接口全路径为名字的文件,文件内容为你所想调用的接口实现类(可以多个)的全路径名
 * 
 * @version 1.0
 */
public class SpiDemo {

	public static void main(String args[]) {
		// 正常调用
		HelloService service = new HelloServiceImpl();
		System.out.println(service.sayHello("xiaoyu"));

		// spi模式调用
		ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class);
		Iterator<HelloService> iter = loader.iterator();
		HelloService s = null;
		while (iter.hasNext()) {
			s = iter.next();
			System.out.println(s.sayHello("bigqi"));
		}
	}
}
