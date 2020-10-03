import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Completable Future example
 * Run the task asynchronously.
 * @Author Anjana Shankar
 * @Created 2020-10-01
 */
public class ExampleCompletableFuture {
    public static void main(String[] args) {
        long started = System.currentTimeMillis();

        CompletableFuture<Integer> futureCount = createCompletableFuture();
        System.out.println("Took " + (started - System.currentTimeMillis()) +
                " milliseconds" );

        try {
            int count = futureCount.get();
            System.out.println("Completable Future took " +
                    (started - System.currentTimeMillis()) +
                    " milliseconds" );
            System.out.println("Result "+count);
        } catch (InterruptedException | ExecutionException e) {
        }

    }

    private static CompletableFuture<Integer> createCompletableFuture() {
        CompletableFuture<Integer> futureCount = CompletableFuture
                .supplyAsync(
                        () -> {
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) { }
                            return 20;
                        }
                );
        return futureCount;
    }
}
