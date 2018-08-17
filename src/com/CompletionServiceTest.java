package com;

import java.util.concurrent.*;

/**
 * 如果想Executor提交了一组计算任务，并且希望在计算完成后获得结果，那么可以保留与每个任务关联的Future，然后反复使用get方法，
 * 同事将参数timeout指定为0，从而通过轮询来判断任务是否完成。这种方法虽然可行，但却有些繁琐。幸运的是，还有一种更好的方法：
 * CompletionService。CompletionService将Executor和BlockingQueue的功能融合在一起。你可以将Callable任务提交给它来执行，
 * 然后使用类似于队列操作的take和poll等方法来获得已完成的结果，而这些结果会在完成时被封装为Future。ExecutorCompletionService实现了CompletionService,
 * 并将计算部分委托到一个Executor。代码示例如下
 */
public class CompletionServiceTest {
    public static void main(String[] args) {
        int coreNum = 4;

        ExecutorService executor = Executors.newFixedThreadPool(coreNum);
        CompletionService<Object> completionService = new ExecutorCompletionService<Object>(executor);
        for(int i=0;i<coreNum;i++)
        {
            completionService.submit( new Callable<Object>(){

                @Override

                public Object call() throws Exception

                {
                    return Thread.currentThread().getName();
                }});
        }
        for(int i=0;i<coreNum;i++)
        {
            try
            {

                Future<Object> future = completionService.take();
                System.out.println(future.get());
            }
            catch (InterruptedException | ExecutionException e)
            {
                e.printStackTrace();
            }

        }

        System.out.println("====end====");
    }
}
