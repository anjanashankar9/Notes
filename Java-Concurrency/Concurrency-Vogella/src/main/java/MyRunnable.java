import java.util.ArrayList;
import java.util.List;

/**
 * Count the sum of a given range of numbers.
 * @Author Anjana Shankar
 * @Created 2020-09-30
 */

class ExampleRunnable implements Runnable {
    private final long countUntil;

    ExampleRunnable(long c) {
        this.countUntil = c;
    }

    @Override
    public void run() {
        long sum = 0;
        for (long i = 1; i < countUntil; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}

public class MyRunnable {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for(int i=0; i< 500; i++) {
            Runnable task = new ExampleRunnable(10000000L + i);
            Thread worker = new Thread(task);
            worker.setName(String.valueOf(i));
            threads.add(worker);
        }

        int running = 0;
        do {
            for(Thread t: threads) {
                if(t.isAlive()) {
                    running ++;
                }
            }
            System.out.println("We have "+running+" running Threads");
        }while(running > 0);
    }
}

