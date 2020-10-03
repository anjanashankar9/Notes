/**
 * Thread Pools with the executor framework.
 * @Author Anjana Shankar
 * @Created 2020-09-30
 */


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class ExampleExecutor {
    private static final int NThreads = 10;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NThreads);

        for(int i=0; i< 500; i++) {
            Runnable worker = new ExampleRunnable(10000000L + i);
            executor.execute(worker);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(10L, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished all threads");
    }
}
