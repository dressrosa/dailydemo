/**
 * 唯有读书,不慵不扰
 */
package com.xiaoyu.modules.demo.callback;

import java.util.Random;

/**
 * @author:xiaoyu 2017年3月18日下午9:56:51
 *
 * @description:接收消息,响应不同的回调
 */
public class Server {

	public void receive(String msg, EventCallback callback) {
		System.out.println("\"" + msg + "\"" + "正在被服务器处理中...");
		Random r = new Random();
		int n = r.nextInt(4);
		try {
			Thread.sleep(n * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (n <= 2) {
			callback.onSuccess();
		} else {
			callback.onFailure();
		}

	}
}
