package com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterLock implements Runnable{
	public static ReentrantLock lock=new ReentrantLock();
	public static ReenterLock reenterLock=new ReenterLock();
	public static Integer i=0;
	@Override
	public void run() {
		for(int j=0;j<10000000;j++){
//			lock.lock();
//			try {
//				i++;
//			} catch (Exception e) {
//				// TODO: handle exception
//			}finally {
//				lock.unlock();
//			}
			synchronized (reenterLock) {
				i++;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(new ReenterLock());
		Thread t2=new Thread(new ReenterLock());
		t1.start();t2.start();
		t1.join();t2.join();
		System.out.println(i);
		List<Integer> list=new ArrayList<Integer>();
		list.add(100);
	}


}
