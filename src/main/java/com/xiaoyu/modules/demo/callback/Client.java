/**
 * 唯有看书,不庸不扰
 */
package com.xiaoyu.modules.demo.callback;

/**
 * @author:xiaoyu 2017年3月18日下午9:55:51
 *
 * @description:client开启new Thread异步发送 消息,并对回调进行处理
 */
public class Client {

	private Server server;

	public Client connect(Server server) {
		this.server = server;
		return this;
	}

	public void send(final String msg, final EventCallback callback) {
		System.out.println("发送信息中...");
		if (null == server)
			throw new IllegalArgumentException("server is null");

		new Thread(new Runnable() {
			public void run() {
				server.receive(msg, callback);
			}
		}).start();

	}
}
