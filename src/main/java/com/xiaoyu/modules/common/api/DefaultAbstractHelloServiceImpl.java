/**
 * 唯有读书,不慵不扰
 */
package com.xiaoyu.modules.common.api;

public abstract class DefaultAbstractHelloServiceImpl implements HelloService {

	public String sayHello(String name) {
		System.out.println("我是"+name);
		return "你好啊,喜欢么?" + name;
	}

}
