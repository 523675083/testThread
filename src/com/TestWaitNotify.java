package com;

public class TestWaitNotify {
	public static void main(String[] args){	
		final Business business= new Business();
		new Thread(
				new Runnable() {		
					public void run() {
						for(int i=1;i<=50;i++){
							business.sub(i);
						}
					}
				}	
		).start();
		for(int i=1;i<=50;i++){
			business.main(i);
		}
	}
}