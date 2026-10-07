import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

/**
 * Solution for LeetCode 1115 - Print FooBar Alternately
 *
 * Problem: Coordinate two threads to print "FooBar" alternately n times
 * using thread synchronization primitives.
 *
 * Key Concepts:
 * - Semaphores: Binary semaphores to control thread execution order
 * - Hand-off pattern: One thread signals the other to proceed
 * - Mutual exclusion: Only one thread runs at a time
 */

/**
 * Solution 1: Using Semaphores (Recommended)
 * Time Complexity: O(n) where n is the number of iterations
 * Space Complexity: O(1)
 */
class FooBarSemaphore {
    private int n;
    private Semaphore fooSem;
    private Semaphore barSem;

    public FooBarSemaphore(int n) {
        this.n = n;
        this.fooSem = new Semaphore(1);  // Foo starts first
        this.barSem = new Semaphore(0);  // Bar is initially blocked
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSem.acquire();      // Wait for signal to print Foo
            printFoo.run();        // Print "Foo"
            barSem.release();      // Signal Bar to print
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSem.acquire();      // Wait for signal to print Bar
            printBar.run();        // Print "Bar"
            fooSem.release();      // Signal Foo to print again
        }
    }
}
