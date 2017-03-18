package com.xiaoyu.modules.demo.spi;

import com.xiaoyu.modules.common.api.HelloService;

public class HelloServiceImpl implements HelloService {

	public String sayHello(String name) {
		return "你好啊!" + name;
	}

}
