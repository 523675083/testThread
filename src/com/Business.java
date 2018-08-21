package com;

class Business {
	private boolean bShouldSub = true;

	public synchronized void sub(int i) {
		//如果bussiness调用sub的话，则【!bShouldSub =false，bShouldSub=true】;
		//然后主线程main为等待，执行完sub后就bShouldSub=false；唤醒主线程main。
		while (!bShouldSub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int j = 1; j <= 10; j++) {
			System.out.println("sub thread sequence of " + j + ",loop of " + i);
		}
		bShouldSub = false;
		//唤醒main 
		this.notify();
	}

	public synchronized void main(int i){
		while(bShouldSub){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int j=1;j<=100;j++){
			System.out.println("main thread sequence of "+j+",loop of "+i);
		}
		bShouldSub = true;
		//唤醒sub
		this.notify();
	}
}