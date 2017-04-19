/*
 *  唯有读书,不慵不扰
 */
package com.xiaoyu.modules.demo.concurrent.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * 2017年4月19日上午9:59:30
 * 
 * @author xiaoyu
 * @description forkjoin框架相当于mapreduce,进行任务拆分,并行计算,达到多核利用
 *              这里继承RecursiveTask,实现compute(),实现俩数之间的计算
 */
public class CountTask extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 1L;

	private int start;
	private int end;

	public CountTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	/**
	 * 设定一个阈值,在这值之内不再拆分,进行和的计算,这个值再实际情况应该取单线程和多线程计算没有差别的时候,因为分的太多,
	 * 反而太慢,可能都不如单线程.分的太少利用率就不高. 相当于递归的退出条件
	 */
	private static final int THRESHOLD = 1000_00;

	@Override
	protected Integer compute() {
		if (end - start <= THRESHOLD) {
			int sum = 0;
			for (int i = start; i <= end; i++) {
				sum += i;
			}
			return sum;
		}
		int middle = (start + end) / 2;
		CountTask t1 = new CountTask(start, middle);
		CountTask t2 = new CountTask(middle + 1, end);
		t1.fork();
		//我们设计的目的是分拆任务,但是要减少阻塞,所以阻塞的程度要尽量的小.这里换成t1.join()+t2.compute()效率就形同下面的错误示范
		return t2.compute() + t1.join();
	 
	}
	
	//这种是错误版本,因为join()是阻塞函数,fork()为分叉,是非阻塞函数,这里的错误思想在于虽然先对
	//t1,t2进行完全拆分,然后join等待结果,但是t2.join()是必须等待t1结果出来后,才能继续计算,就相当于一开始
	//我们只是将任务拆分了,但是结果还是先阻塞计算前一半,然后再进行后一半,这里的效率几乎慢一半
//	@Override
//	protected Integer compute() {
//		if (end - start <= THRESHOLD) {
//			int sum = 0;
//			for (int i = start; i <= end; i++) {
//				sum += i;
//			}
//			return sum;
//		}
//		int middle = (start + end) / 2;
//		CountTask t1 = new CountTask(start, middle);
//		CountTask t2 = new CountTask(middle + 1, end);
//		t1.fork();
//		t2.fork();
//		return t1.join() + t2.join();
//	}

}
