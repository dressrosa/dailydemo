/**
 * 唯有读书,不慵不扰
 */
package com.xiaoyu.modules.demo.observe.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * 2017年3月22日下午7:27:36
 * 
 * @author xiaoyu
 * @description jdk自带观察者
 * 
 */
public class JdkObserveTest {

	public static void main(String[] args) {
		JdkObservable boss1 = new JdkObservable();
		boss1.addObserver(new Observer() {
			/*
			 * update 参数带有Observable的原因是被观察者的实现可能有多种 这里可以做判断是从哪个boss里面传来的通知
			 * 愚以为没啥用,被观察者对于观察者来说,观察者应该只是被动的接受,而不应该有主动的响应动作, 比如还要判断是哪个被观察者.
			 * 这样二者就没有完全解耦了啊
			 */
			@Override
			public void update(Observable o, Object arg) {
				if (o instanceof JdkObservable) {
					System.out.println("hello " + arg);
				}
			}
		});
		/*
		 * 必须设置changed才会通知,避免改变频繁的话一直通知,可以设置一定条件下才会通知.
		 * 愚以为也没啥用,因为订阅是观察者的主动行为,所以目的是接收通知,而boss通知观察者应该是
		 * 主动行为,主动行为为何还要做限制,你想通知的就通知,不想的时候不调用不就行了
		 */
		boss1.setChanged();
		boss1.notifyObservers("xiaoyu");
	}

}