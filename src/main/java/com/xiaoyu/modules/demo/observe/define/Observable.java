/**
 * 唯有看书,不庸不扰
 **/
package com.xiaoyu.modules.demo.observe.define;

import java.util.Collection;

/**
 * 2017年3月22日下午7:13:03
 * 
 * @author xiaoyu
 * @description 被观察者 设置成接口的模式更有灵活性 这里的订阅取消都是被动的意思
 */
public interface Observable {

	public void notifyObservers(Object args);

	public Observable subscribe(Observer ob);

	public Observable subscribe(Collection<Observer> obs);

	public Observable unsubscribe(Observer ob);
}
