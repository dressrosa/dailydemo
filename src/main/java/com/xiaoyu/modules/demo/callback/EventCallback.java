/**
 * 唯有读书,不慵不扰
 */
package com.xiaoyu.modules.demo.callback;

/**
 * @author:xiaoyu 2017年3月18日下午9:53:04
 *
 * @description:回调机制主要大意就是 回调事件由客户端实现,服务端进行调用, 客户端进行响应
 * 我最常见的应该就是安卓和js里面的按钮点击事件吧
 */
public interface EventCallback {

	void onSuccess();

	void onFailure();

}
