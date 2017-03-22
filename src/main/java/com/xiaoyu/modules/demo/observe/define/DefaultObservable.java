/**
 * 唯有看书,不庸不扰
 **/
package com.xiaoyu.modules.demo.observe.define;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 2017年3月22日下午5:00:11
 * 
 * @author xiaoyu
 * @description 被观察者
 */
public class DefaultObservable implements Observable {

	private Set<Observer> obHolder = new HashSet<>();

	public void notifyObservers(Object args) {
		if (obHolder.size() == 0)
			return;
		synchronized (obHolder) {
			Iterator<Observer> iter = obHolder.iterator();
			while (iter.hasNext()) {
				iter.next().update(args);
			}
		}
	}

	public Observable subscribe(Observer ob) {
		obHolder.add(ob);
		return this;
	}

	public Observable subscribe(Collection<Observer> ob) {
		obHolder.addAll(ob);
		return this;
	}

	public Observable unsubscribe(Observer ob) {
		obHolder.remove(ob);
		return this;
	}
}
