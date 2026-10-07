# Explanation

## Concept: Dynamic Programming (DP)

We track the minimum steps needed by considering whether to modify the current element based on the previous state. The key insight is that each element can either remain unchanged (if it satisfies non-decreasing with previous) or be replaced at a cost of 1 step.

We use DP to compute the optimal minimum steps by considering the state of elements as we traverse the array.
