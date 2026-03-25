package practice.p10_concurrency;

/**
 * ThreadBasicsDemo.java — Concurrency Fundamentals: Threads, Synchronization, Executors
 * =======================================================================================
 * CSE215 - Programming Language II
 *
 * 💡 INTUITION: A thread is an independent path of execution within a program.
 *    Think of a restaurant:
 *      - Single-threaded: One waiter serves all tables sequentially
 *      - Multi-threaded: Multiple waiters serve tables simultaneously
 *
 *    Concurrency challenges are like a shared kitchen:
 *      - Two chefs reaching for the same ingredient at the same time = race condition
 *      - Solution: only one chef can use the spice rack at a time = synchronization
 *
 * Topics covered:
 *   1. Creating threads (Thread class vs Runnable interface)
 *   2. Thread lifecycle and methods (start, sleep, join, interrupt)
 *   3. Race conditions (the problem)
 *   4. Synchronization (the solution: synchronized, locks)
 *   5. Thread-safe collections
 *   6. ExecutorService (modern thread management)
 *   7. Callable and Future
 *
 * ⚠️ NOTE: Output order may vary between runs — that's the nature of concurrency!
 *
 * 🔗 SEE ALSO: p08_LambdasAndStreams/StreamsDemo.java (parallel streams)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadBasicsDemo {

    // =====================================================================
    // Approach 1: Extending Thread class
    // =====================================================================

    /**
     * 📌 RULE: Extending Thread is simpler but limits you (can't extend another
     * class).
     * Prefer Runnable or Callable for flexibility.
     */
    static class CounterThread extends Thread {
        private final String name;

        CounterThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.printf("    [%s] Count: %d%n", name, i);
                try {
                    Thread.sleep(100); // Pause 100ms to simulate work
                } catch (InterruptedException e) {
                    System.out.println("    [" + name + "] Interrupted!");
                    return;
                }
            }
            System.out.printf("    [%s] Done!%n", name);
        }
    }

    // =====================================================================
    // Approach 2: Implementing Runnable (preferred)
    // =====================================================================

    /**
     * ✅ BEST PRACTICE: Implement Runnable (or use lambda) instead of extending
     * Thread.
     * - Can still extend another class
     * - Separates task logic from thread management
     * - Can be used with ExecutorService
     */
    static class DownloadTask implements Runnable {
        private final String filename;

        DownloadTask(String filename) {
            this.filename = filename;
        }

        @Override
        public void run() {
            System.out.println("    Downloading " + filename + "...");
            try {
                Thread.sleep((long) (Math.random() * 500 + 100)); // Simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("    ✓ Downloaded " + filename);
        }
    }

    // =====================================================================
    // Race Condition Example
    // =====================================================================

    /**
     * ⚠️ GOTCHA: Without synchronization, multiple threads modifying shared
     * state leads to race conditions — unpredictable, incorrect results.
     */
    static class UnsafeCounter {
        private int count = 0;

        void increment() {
            count++; // NOT atomic: read → modify → write (3 steps!)
        }

        int getCount() {
            return count;
        }
    }

    /**
     * ✅ SOLUTION 1: synchronized keyword
     * Only one thread can execute synchronized methods/blocks at a time.
     */
    static class SafeCounter {
        private int count = 0;

        synchronized void increment() {
            count++; // Now only one thread at a time
        }

        synchronized int getCount() {
            return count;
        }
    }

    /**
     * ✅ SOLUTION 2: AtomicInteger (better for simple counters)
     * Uses hardware-level atomic operations — faster than synchronized.
     */
    static class AtomicCounter {
        private final AtomicInteger count = new AtomicInteger(0);

        void increment() {
            count.incrementAndGet();
        }

        int getCount() {
            return count.get();
        }
    }

    // =====================================================================
    // MAIN
    // =====================================================================
    public static void main(String[] args) throws Exception {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║   THREAD BASICS DEMO                         ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");

        // =================================================================
        // 1. Creating and Starting Threads
        // =================================================================
        System.out.println("=== 1. CREATING THREADS ===");

        // Way 1: Extend Thread
        System.out.println("--- Extending Thread ---");
        CounterThread t1 = new CounterThread("Thread-A");
        CounterThread t2 = new CounterThread("Thread-B");

        t1.start(); // ✅ start() creates new thread and calls run()
        t2.start();

        // ⚠️ GOTCHA: NEVER call run() directly — it runs in the current thread!
        // t1.run(); // ❌ This does NOT create a new thread

        t1.join(); // Wait for t1 to finish
        t2.join(); // Wait for t2 to finish
        System.out.println("Both counting threads finished.\n");

        // Way 2: Implement Runnable
        System.out.println("--- Implementing Runnable ---");
        Thread d1 = new Thread(new DownloadTask("file1.pdf"));
        Thread d2 = new Thread(new DownloadTask("file2.jpg"));
        d1.start();
        d2.start();
        d1.join();
        d2.join();
        System.out.println("All downloads finished.\n");

        // Way 3: Lambda (since Runnable is a functional interface)
        System.out.println("--- Lambda Runnable ---");
        Thread lambdaThread = new Thread(() -> {
            System.out.println("    Hello from lambda thread! ID: " + Thread.currentThread().threadId());
        });
        lambdaThread.start();
        lambdaThread.join();

        // =================================================================
        // 2. Thread Lifecycle & Methods
        // =================================================================
        System.out.println("\n=== 2. THREAD LIFECYCLE ===");

        /**
         * Thread States:
         * NEW → RUNNABLE → RUNNING → (BLOCKED/WAITING/TIMED_WAITING) → TERMINATED
         *
         * new Thread() → NEW
         * .start() → RUNNABLE (waiting for CPU)
         * CPU schedules it → RUNNING
         * .sleep() / .wait() → TIMED_WAITING / WAITING
         * synchronized block → BLOCKED (waiting for lock)
         * run() completes → TERMINATED
         */

        Thread lifecycle = new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        System.out.println("Before start: " + lifecycle.getState()); // NEW
        lifecycle.start();
        System.out.println("After start:  " + lifecycle.getState()); // RUNNABLE
        Thread.sleep(50);
        System.out.println("During sleep: " + lifecycle.getState()); // TIMED_WAITING
        lifecycle.join();
        System.out.println("After join:   " + lifecycle.getState()); // TERMINATED

        // =================================================================
        // 3. Race Condition Demonstration
        // =================================================================
        System.out.println("\n=== 3. RACE CONDITIONS ===");

        // Unsafe: race condition
        UnsafeCounter unsafeCounter = new UnsafeCounter();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    unsafeCounter.increment();
                }
            });
            threads.add(t);
            t.start();
        }
        for (Thread t : threads)
            t.join();
        System.out.println("Unsafe (expected 10000): " + unsafeCounter.getCount()
                + (unsafeCounter.getCount() != 10000 ? " ← RACE CONDITION!" : ""));

        // Safe: synchronized
        SafeCounter safeCounter = new SafeCounter();
        threads.clear();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    safeCounter.increment();
                }
            });
            threads.add(t);
            t.start();
        }
        for (Thread t : threads)
            t.join();
        System.out.println("Safe sync (expected 10000): " + safeCounter.getCount());

        // Atomic: best for simple counters
        AtomicCounter atomicCounter = new AtomicCounter();
        threads.clear();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    atomicCounter.increment();
                }
            });
            threads.add(t);
            t.start();
        }
        for (Thread t : threads)
            t.join();
        System.out.println("Atomic (expected 10000): " + atomicCounter.getCount());

        // =================================================================
        // 4. Synchronized Block (finer control)
        // =================================================================
        System.out.println("\n=== 4. SYNCHRONIZED BLOCK ===");

        /**
         * 📌 RULE: You can synchronize on a specific object (lock) instead
         * of the entire method. This gives finer-grained control.
         *
         * synchronized(lockObject) {
         * // only one thread can be here at a time for this lock
         * }
         */

        Object lock = new Object();
        List<String> sharedList = new ArrayList<>();

        Thread writer1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    sharedList.add("W1-" + i);
                }
            }
        });

        Thread writer2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (lock) {
                    sharedList.add("W2-" + i);
                }
            }
        });

        writer1.start();
        writer2.start();
        writer1.join();
        writer2.join();
        System.out.println("Shared list (" + sharedList.size() + " items): " + sharedList);

        // =================================================================
        // 5. Thread-Safe Collections
        // =================================================================
        System.out.println("\n=== 5. THREAD-SAFE COLLECTIONS ===");

        /**
         * 💡 Instead of manually synchronizing, use concurrent collections:
         * - ConcurrentHashMap (instead of synchronized HashMap)
         * - CopyOnWriteArrayList (instead of synchronized ArrayList)
         * - ConcurrentLinkedQueue (thread-safe queue)
         * - BlockingQueue implementations (producer-consumer pattern)
         */

        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
        threads.clear();

        for (int i = 0; i < 5; i++) {
            final int threadNum = i;
            Thread t = new Thread(() -> {
                concurrentMap.put("Thread-" + threadNum, threadNum * 10);
            });
            threads.add(t);
            t.start();
        }
        for (Thread t : threads)
            t.join();
        System.out.println("ConcurrentHashMap: " + concurrentMap);

        // =================================================================
        // 6. ExecutorService (Modern Thread Management)
        // =================================================================
        System.out.println("\n=== 6. EXECUTOR SERVICE ===");

        /**
         * ✅ BEST PRACTICE: Don't manage threads manually. Use ExecutorService.
         * It manages a pool of reusable threads.
         *
         * Types:
         * - newFixedThreadPool(n) — n threads, reused for all tasks
         * - newCachedThreadPool() — creates threads as needed, reuses idle ones
         * - newSingleThreadExecutor() — one thread processing tasks sequentially
         */

        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("Submitting 5 tasks to a pool of 3 threads:");
        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.printf("    Task %d running on %s%n", taskId, Thread.currentThread().getName());
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown(); // No new tasks accepted
        executor.awaitTermination(5, TimeUnit.SECONDS); // Wait for completion
        System.out.println("All executor tasks completed.");

        // =================================================================
        // 7. Callable and Future (Threads that return results)
        // =================================================================
        System.out.println("\n=== 7. CALLABLE AND FUTURE ===");

        /**
         * 💡 Runnable.run() returns void.
         * Callable.call() returns a value and can throw checked exceptions.
         * Future represents the pending result.
         *
         * Callable<V> → call() → returns V
         * Future<V> → get() → blocks until result is ready
         */

        ExecutorService pool = Executors.newFixedThreadPool(3);

        // Submit Callable tasks
        Callable<Integer> task1 = () -> {
            Thread.sleep(200);
            return 42;
        };

        Callable<String> task2 = () -> {
            Thread.sleep(150);
            return "Hello from Callable!";
        };

        Future<Integer> future1 = pool.submit(task1);
        Future<String> future2 = pool.submit(task2);

        System.out.println("Tasks submitted, waiting for results...");
        System.out.println("Result 1: " + future1.get()); // Blocks until ready
        System.out.println("Result 2: " + future2.get());

        // invokeAll — submit multiple callables and get all results
        List<Callable<Integer>> computations = List.of(
                () -> {
                    Thread.sleep(100);
                    return 10;
                },
                () -> {
                    Thread.sleep(200);
                    return 20;
                },
                () -> {
                    Thread.sleep(150);
                    return 30;
                });

        List<Future<Integer>> results = pool.invokeAll(computations);
        int total = 0;
        for (Future<Integer> f : results) {
            total += f.get();
        }
        System.out.println("Sum of all results: " + total);

        pool.shutdown();

        System.out.println("\n✅ All demos completed successfully!");
    }
}

/*
 * ╔═══════════════════════════════════════════════════════════════════╗
 * ║ CONCURRENCY CHEAT SHEET ║
 * ╠═══════════════════════════════════════════════════════════════════╣
 * ║ Create threads: ║
 * ║ extends Thread → override run(), call start() ║
 * ║ implements Runnable → new Thread(runnable).start() ║
 * ║ lambda → new Thread(() -> {...}).start() ║
 * ║ ExecutorService → executor.submit(runnable/callable) ║
 * ║ ║
 * ║ Protect shared state: ║
 * ║ synchronized method → simple, locks whole method ║
 * ║ synchronized(obj) {} → fine-grained, locks specific block ║
 * ║ AtomicInteger/Long/Ref → lock-free atomic operations ║
 * ║ ConcurrentHashMap → thread-safe map without locking all ║
 * ║ ║
 * ║ Modern approach: ║
 * ║ ExecutorService + Callable + Future ║
 * ║ ║
 * ║ 📌 ALWAYS call executor.shutdown() when done. ║
 * ║ 📌 NEVER call thread.run() — use thread.start(). ║
 * ║ ⚠️ Thread.sleep() can throw InterruptedException. ║
 * ╚═══════════════════════════════════════════════════════════════════╝
 */
