/**
 * 唯有读书,不慵不扰
 */
package com.xiaoyu.modules.demo.observe.jdk;

import java.util.Observable;

/**
 * 2017年3月22日下午7:27:36
 * 
 * @author xiaoyu
 * @description jdk自带观察者 想要使用必须继承Observable 因为原生的
 *              Observable设计成必须有changed的才会通知,而setChanged为protected,无法直接使用
 * 
 * 
 */
public class JdkObservable extends Observable {

	@Override
	public synchronized void setChanged() {
		super.setChanged();
	}

}