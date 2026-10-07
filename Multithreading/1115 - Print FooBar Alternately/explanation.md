# Explanation

## Concept: Multithreading & Synchronization

This problem requires coordinating two threads to execute in a specific alternating order. The key concepts are:

### Synchronization Primitives

**Semaphores**: A counter-based synchronization mechanism
- `acquire()`: Decrements the counter; blocks if counter is 0
- `release()`: Increments the counter and wakes a waiting thread
- Used to control access and signal between threads

### Approach

1. Create two semaphores: `fooSem` (initialized to 1) and `barSem` (initialized to 0)
2. In the `foo()` method:
   - Acquire `fooSem` (initially available)
   - Print "Foo"
   - Release `barSem` to signal the bar thread
3. In the `bar()` method:
   - Acquire `barSem` (initially blocked)
   - Print "Bar"
   - Release `fooSem` to signal the foo thread again

This creates a hand-off pattern where:
- Foo runs first (because `fooSem` starts at 1)
- Foo completes and signals Bar
- Bar runs and signals Foo
- Pattern repeats n times

### Alternative Approaches

- **Locks with Condition Variables**: More flexible but more verbose
- **ReentrantLock + Condition**: Java's higher-level abstraction
- **CyclicBarrier/CountDownLatch**: Different synchronization strategies
- **Atomic Variables**: For simpler coordination patterns
