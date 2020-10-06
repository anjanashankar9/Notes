import java.util.concurrent.atomic.AtomicInteger;

/**
 * Creates a counter that is always increasing in a non blocking way.
 * @Author Anjana Shankar
 * @Created 2020-10-06
 */
public class NonBlockingIncreasingCounter {
    private AtomicInteger value = new AtomicInteger();

    public int getValue() {
        return value.get();
    }

    public int increment() {
        return value.incrementAndGet();
    }

    // Alternative implementation as increment.
    public int incrementExplicit() {
        int oldValue = value.get();
        while(!value.compareAndSet(oldValue, oldValue+1)) {
            oldValue = value.get();
        }
        return oldValue+1;
    }

}
