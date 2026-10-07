# 1115 - Print FooBar Alternately

## Problem Statement

Suppose you are given the following code:

```
class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("Foo");
    }
  }

  public void bar() {
    for (int i = 0; i < n; i++) {
      print("Bar");
    }
  }
}
```

The same instance of `FooBar` will be passed to two different threads:
- thread A will call `foo()`, and 
- thread B will call `bar()`.

Modify the given program to ensure that "Foo" is always printed before "Bar". 

If the given program is executed, one possible output is "FooBarFooBarFooBar". If the given program is executed, another possible output could be "FooFooBarBarFooBar", which is incorrect.

## Constraints

- `1 <= n <= 1000`
- Both `foo` and `bar` will be called by different threads concurrently
- You cannot use any built-in function that directly solves the problem (e.g., `Thread.join()`)

## Example

Input: `n = 1`
Output: `"FooBar"`
