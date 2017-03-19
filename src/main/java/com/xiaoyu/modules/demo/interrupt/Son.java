/**
 * 唯有看书,不庸不扰
 */
package com.xiaoyu.modules.demo.interrupt;

/**
 * @author:xiaoyu 2017年3月19日下午11:55:21
 *
 * @description:做作业的场景来模拟中断的操作
 */
public class Son {

	public static void main(String[] args) throws InterruptedException {
		final Son son = new Son();
		Thread study = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					son.doHomeWork();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread play = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					son.playWithFriends();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		study.start();
		Thread.sleep(1);
		play.start();
		play.join();// 玩心上来了 ,停止学习来玩
		System.out.println("main线程");
	}

	public void doHomeWork() throws InterruptedException {
		System.out.println("作业中...");
		Thread.sleep(1500);
		System.out.println("作业完毕,继续去玩");
	}

	public void playWithFriends() throws InterruptedException {
		System.out.println("娱乐中...");
		Thread.sleep(1000);
		this.seeDadComing();
		for (int i = 0; i < 2000_000; i++)
			for (int j = 0; j < 1000_00; j++) {
				if (i == 1000_0 && j == 1000_0)// 只是用来增加时间
					i = (i + 1) - 1;
			}
		System.out.println("娱乐完毕");
	}

	private void seeDadComing() {
		// 应该中断play活动,赶紧写作业,就是study线程恢复
		Thread.currentThread().interrupt();
		System.out.println("老爹来了,赶紧做作业....");
	}
}
