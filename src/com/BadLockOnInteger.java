package com;

public class BadLockOnInteger implements Runnable{
	public static Integer  i=0;
	public static BadLockOnInteger badLockOnInteger=new BadLockOnInteger();
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(badLockOnInteger);
		Thread t2=new Thread(new BadLockOnInteger());
		t1.start();t2.start();
		t1.join();t2.join();
		System.out.println(i);
		System.out.println();
	}
	@Override
	public void run() {
		for(int j=0;j<10000000;j++){
			synchronized (badLockOnInteger) {
				i++;
			}
		}
	}
	

}
