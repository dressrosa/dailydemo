/**
 * 唯有读书,不慵不扰
 */
package com.xiaoyu.modules.demo.observe.define;

/**
 * 2017年3月22日下午5:47:06
 * 
 * @author xiaoyu
 * @description 测试
 */
public class ObTest {

	public static void main(String[] args) {
		Observable boss = new DefaultObservable();
		boss.subscribe(new Observer() {
			// 观察者只需要被动的响应就行
			@Override
			public void update(Object args) {
				System.out.println(args);
			}

		}).notifyObservers("星期一,请保持好心情哦");

	}
}