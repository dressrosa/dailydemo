/**
 * 唯有看书,不庸不扰
 */
package com.xiaoyu.modules.demo.interrupt;

/**
 * @author:xiaoyu 2017年3月19日下午11:28:31
 *
 * @description:设置自定义标识位,主动抛出异常
 */
public class SimpleFlag implements Runnable {

	public static void main(String[] args) throws InterruptedException {
		SimpleFlag s = new SimpleFlag();
		Thread t1 = new Thread(s, "t1");
		Thread t2 = new Thread(s, "t2");
		t2.start();
		t1.start();

		while (true)
			if (t1.isInterrupted()) {
				System.out.println("t1 interrupt");
				throw new InterruptedException();
			}
	}

	private volatile static boolean stop = false;

	@Override
	public void run() {
		while (!stop) {
			for (int a = 0; a < 1000_000_0; a++)
				for (int b = 0; b < 1000_000; b++) {
					if (a == 1000_00 && b == 1000_0)
						this.doStop();
				}
		}
		System.out.println(Thread.currentThread().getName() + " go on...");
	}

	private void doStop() {
		stop = true;
		Thread.currentThread().interrupt();
	}

}
