/**
 * 唯有读书,不慵不扰
 */
package com.xiaoyu.modules.demo.observe.define;

/**
 * 2017年3月22日下午5:03:23
 * 
 * @author xiaoyu
 * @description 观察者
 */
public interface Observer {

	/**
	 * 不再遵循jdk里面的观察者设计,只是有一个args传入观察者方法中的参数
	 */
	public void update(Object args);

}
