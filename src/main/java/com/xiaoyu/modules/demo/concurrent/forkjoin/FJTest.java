/*
 *  唯有读书,不慵不扰
 */
package com.xiaoyu.modules.demo.concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * 2017年4月19日上午10:49:10
 * 
 * @author xiaoyu
 * @description
 */
public class FJTest {

	public static void main(String[] args) throws Exception {
		CountTask task = new CountTask(0, 1000_000_00);

		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Integer> result = pool.submit(task);
		System.out.println(result.get());
	}

}
