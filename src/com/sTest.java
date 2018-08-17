package com;

public class sTest {
        //实例方法同步
        public synchronized void add(){
            for(int i=0 ;i<100;i++){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
        //实例方法中的同步块
        public void addQ1(){
            synchronized(this){
                for(int i=600 ;i<700;i++){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        }
        public void addQ2(){
            synchronized(this){
                for(int i=700 ;i<800;i++){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        }
        public void addQ3(String s){
            synchronized(s){
                for(int i=800 ;i<900;i++){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        }
        public void addQ4(String s){
            synchronized(s){
                for(int i=900 ;i<1000;i++){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        }

    public static void main(String[] args) {
        final sTest sTest =new sTest();
        final sTest sTest1=new sTest();
        final String s = "1";
        final String s2 = "2";
        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                sTest.addQ3(s);
            }
        },"thread1");

        Thread thread2 = new Thread(new Runnable(){
            @Override
            public void run() {
                sTest1.addQ4(s2);
            }
        },"thread2");

        thread1.start();
        thread2.start();
    }
}