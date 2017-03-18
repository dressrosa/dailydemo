package com.xiaoyu.modules.common.api;

public class DefaultHelloServiceImpl implements HelloService {

	public String sayHello(String name) {
		System.out.println("我是"+name);
		return "你好啊,喜欢么?" + name;
	}

}
