/**
 * 唯有看书,不庸不扰
 */
package com.xiaoyu.modules.demo.interrupt;

/**
 * @author:xiaoyu 2017年3月19日下午11:11:26
 *
 * @description:介绍三个方法的应用
 */
public class SimpleDemo {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Runnable() {
			public void run() {
				System.out.println("任务开始...");
				for (int i = 0; i < 1000_000; i++)
					for (int j = 0; j < 1000_000; j++) {
						// 增加运行时间而已
					}
				System.out.println("清除信号:是否中断过:" + "1." + Thread.interrupted() + " 2." + Thread.interrupted());
				for (int i = 0; i < 1000_000; i++)
					for (int j = 0; j < 1000_000; j++) {

					}
			}
		});

		t.start();
		Thread.sleep(1);// 这里是mian线程的sleep 不影响t
		t.interrupt();// 中断
		while (t.isAlive()) {
			System.out.println("不清除信号:是否中断过:" + "1." + t.isInterrupted() + " 2." + t.isInterrupted());
			Thread.sleep(1);
		}
		System.out.println("main线程");
	}
}
