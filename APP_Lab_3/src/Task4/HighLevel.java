package Task4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HighLevel {
    public static void main(String[] args) {
        final ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.submit(() -> Calculations.increment(16,9));
        executor.submit(() -> Calculations.decrement(50,40));
        executor.submit(() -> Calculations.multi(4,5));
        executor.submit(() -> Calculations.division(36.6,6));

        executor.shutdown();
    }
}
