package com;

import java.util.HashSet;
import java.util.concurrent.*;

public class TestCountDown {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int countNum=250;
        CountDownLatch countDownLatch = new CountDownLatch(countNum);
        ExecutorService executorService = Executors.newFixedThreadPool(countNum);
        CompletionService<HashSet> completionService = new ExecutorCompletionService<>(executorService);
        final HashSet hs = new HashSet();
        HashSet hs1 = new HashSet();
        for (int i = 0; i < countNum; i++) {
            completionService.submit(new Callable<HashSet>() {
                @Override
                public HashSet call() throws Exception {
                    hs.add(Thread.currentThread().getName());
                    countDownLatch.countDown();
                    return hs;
                }
            });
        }
        countDownLatch.await();
        hs1=completionService.take().get();
        System.out.println(hs1.size());
    }
}
