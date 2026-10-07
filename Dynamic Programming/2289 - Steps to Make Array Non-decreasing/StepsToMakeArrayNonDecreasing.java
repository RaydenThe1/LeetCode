import java.util.*;

/**
 * Solution for LeetCode 2289 - Steps to Make Array Non-decreasing
 *
 * Approach: Dynamic Programming with State Tracking
 *
 * The key insight is that we need to track:
 * - Whether we modified the previous element or not
 * - The minimum number of steps taken so far
 *
 * For each element at index i, we have two choices:
 * 1. Keep it unchanged if it's >= previous element
 * 2. Replace it (cost = 1 step)
 *
 * If we replace nums[i], we can set it to any value in range [nums[i+1] - nums[i], nums[i+1]]
 * This means if we replace nums[i], the best value we can set is nums[i+1] itself,
 * which guarantees nums[i] <= nums[i+1].
 */
public class StepsToMakeArrayNonDecreasing {

    /**
     * Find minimum steps to make array non-decreasing
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums array of positive integers
     * @return minimum number of steps required
     */
    public int totalSteps(int[] nums) {
        int n = nums.length;
        int steps = 0;

        // Stack to keep track of elements and their replacement costs
        // Each entry: [value, steps_to_make_this_valid]
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int currentSteps = 0;

            // Pop all elements that are greater than current element
            // These elements need to be replaced
            while (!stack.isEmpty() && stack.peek()[0] > nums[i]) {
                currentSteps = Math.max(currentSteps, stack.pop()[1]);
            }

            // If current element is still greater than the element before it,
            // we need to replace current element with the previous one
            if (!stack.isEmpty() && stack.peek()[0] == nums[i]) {
                // Current element equals previous, no additional step needed
                // but we inherit any pending steps from the previous element
                currentSteps = Math.max(currentSteps, stack.pop()[1]);
            }

            // If we had to modify previous elements, current element needs modification too
            if (currentSteps > 0) {
                currentSteps++;
            }

            // Push current element and its modification cost
            if (currentSteps > 0 || !stack.isEmpty()) {
                stack.push(new int[]{nums[i], currentSteps});
            } else {
                stack.push(new int[]{nums[i], 0});
            }

            steps = Math.max(steps, currentSteps);
        }

        return steps;
    }

    /**
     * Alternative approach: More intuitive DP solution
     * Tracks the minimum steps needed considering each element's state
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums array of positive integers
     * @return minimum number of steps required
     */
    public int totalStepsDP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] = min steps to make nums[0...i] non-decreasing

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                // Current element is less than previous
                // We need to replace it with previous value
                dp[i] = dp[i - 1] + 1;

                // Check if we need to replace more previous elements
                // because current element (when replaced) will be less than them
                int j = i - 1;
                while (j > 0 && nums[j - 1] > nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j - 1] + (i - j + 1));
                    j--;
                }
            } else {
                // Current element >= previous, inherit dp value
                dp[i] = dp[i - 1];
            }
        }

        return dp[n - 1];
    }
}
