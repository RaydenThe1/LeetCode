How it works

- We maintain a monotonic stack of strictly decreasing values (bottom → top), each tagged with the step in which it gets removed (0 if never).
- For each element x, we pop all stack tops ≤ x — those lie between x and its nearest greater element on the left. We track the maximum removal step among them.
- x's removal step = maxPopped + 1 (it can only be removed after those in-between elements disappear). If the stack is empty, there's no greater left neighbor, so x never gets removed (step = 0).
- The answer is the maximum removal step across all elements, which equals the total number of rounds needed.

Complexity: O(n) time, O(n) space.