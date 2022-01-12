package javacoreexample.threadsconcurrent.executorservice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        System.out.println("Submit worker 1");
        Future<String> future1 = executorService.submit(new Worker("worker 1"));

        System.out.println("Submit worker 1");
        Future<String> future2 = executorService.submit(new Worker("worker 2"));

        System.out.println("Result from worker1: " + future1.get());
        System.out.println("Result from worker2: " + future2.get());

        System.out.println("-----------------------");

        System.out.println("Submit workers using invokeAll()");
        List<Future<String>> futureListInvokeAll = executorService.invokeAll(
                Arrays.asList(new Worker("worker 3"), new Worker("worker 4"), new Worker("worker 5")));

        System.out.println("Exited invokeAll()");
        for (Future<String> future : futureListInvokeAll) {
            System.out.println("Result from worker: " + future.get());
        }

        executorService.shutdown();
        executorService.awaitTermination(10L, TimeUnit.SECONDS);
    }

    private static class Worker implements Callable<String> {

        private final String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public String call() throws Exception {
            long sleepTime = (long) (Math.random() * 10000L);
            System.out.println(name + " started, going to sleep for " + sleepTime + "ms");
            Thread.sleep(sleepTime);
            System.out.println(name + " finished");
            return name;
        }
    }
}
