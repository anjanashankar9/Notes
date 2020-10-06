import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-01
 */
public class ExampleCompletableFutureDelayed {
    public static void main(String[] args) {
        long started = System.currentTimeMillis();

        CompletableFuture<String> data = createCompletableFuture()
                .thenApply((Integer count) -> {
                    int transformedValue = count * 10;
                    return transformedValue;
                }).thenApply(transformed -> "Finally creates a string: "+
                        transformed);

        try {
            System.out.println(data.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static CompletableFuture<Integer> createCompletableFuture() {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        future.completeAsync(() -> {
            System.out.println("inside future: processing data...");
            return 1;
        }, CompletableFuture.delayedExecutor(3, TimeUnit.SECONDS))
        .thenAccept(result -> System.out.println("accept: "+result));
        return future;
    }
}
