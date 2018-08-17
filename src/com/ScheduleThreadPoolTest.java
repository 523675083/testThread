package com;

import java.util.concurrent.*;

/**
 * 创建了一个固定长度的线程池，而且以延迟或者定时的方式来执行任务，类似于Timer。
 */
public class ScheduleThreadPoolTest

{

    private static ScheduledExecutorService exec = Executors.newScheduledThreadPool(2);

 

    public static void method1()

    {

        exec.schedule(new Runnable(){

            @Override

            public void run()

            {

                System.out.println("1");

            }}, 2, TimeUnit.SECONDS);

    }

 

    public static void method2()

    {

        ScheduledFuture<String> future = exec.schedule(new Callable<String>(){

            @Override

            public String call() throws Exception

            {

                return "Callable";

            }}, 4, TimeUnit.SECONDS);

        try

        {

            System.out.println(future.get());

        }

        catch (InterruptedException | ExecutionException e)

        {

            e.printStackTrace();

        }

    }

 

    public static void main(String[] args)

    {

        method1();

        method2();

    }

}