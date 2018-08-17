package com;

public class TestInterrupt {
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(){
			@Override
			public void run() {
				while(true){
					if(Thread.currentThread().isInterrupted()){
						System.out.println("中断");
						break;
					}
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						System.out.println("当前线程异常"+e.getMessage());
						Thread.currentThread().interrupt();
					}
					Thread.yield();
				}
			}
		};
		t1.start();
		Thread.sleep(2000);
		t1.interrupt();
	}

}
