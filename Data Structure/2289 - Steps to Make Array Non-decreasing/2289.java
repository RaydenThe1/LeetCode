import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int totalSteps(int[] nums) {
        Deque<int[]> stack = new ArrayDeque<>();
        int ans = 0;

        for (int x : nums) {
            int maxPopped = 0;

            // Pop elements <= current; they can never be a greater
            // left neighbour for any future element.
            while (!stack.isEmpty() && stack.peek()[0] <= x) {
                maxPopped = Math.max(maxPopped, stack.peek()[1]);
                stack.pop();
            }

            int curStep;
            if (stack.isEmpty()) {
                // No greater element on the left → never removed.
                curStep = 0;
            } else {
                // Current element is removed one step after the latest
                // removal among the in‑between elements we just popped.
                curStep = maxPopped + 1;
            }

            ans = Math.max(ans, curStep);
            stack.push(new int[]{x, curStep});
        }

        return ans;
    }
}