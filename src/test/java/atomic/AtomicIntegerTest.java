package atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    private static int normalCounter = 0;
    private static AtomicInteger atomicCounter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 300; i++) {
                // Normal increment (not thread-safe)
                normalCounter++;

                // Atomic increment (thread-safe)
                atomicCounter.incrementAndGet();
            }
        };

        // Start 2 threads
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // Expected: 200000
        System.out.println("Normal counter: " + normalCounter);
        System.out.println("Atomic counter: " + atomicCounter.get());
    }
}
