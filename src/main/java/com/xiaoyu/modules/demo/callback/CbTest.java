/**
 * 唯有读书,不慵不扰
 */
package com.xiaoyu.modules.demo.callback;

public class CbTest {

	public static void main(String[] args) {
		Client client = new Client();
		Server server = new Server();
		
		client.connect(server).send("xiaoyu最好了",  new EventCallback() {
			
			public void onSuccess() {
				System.out.println("发送超时请重新发送");
			}
			
			public void onFailure() {
				System.out.println("发送成功");
			}
		});
	

	}

}
