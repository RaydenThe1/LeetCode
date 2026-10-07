# 2289 - Steps to Make Array Non-decreasing

## Problem Statement

You are given a 0-indexed array of positive integers `nums`.

In one step, you can select an index `i` (where `0 <= i < nums.length - 1`) and replace `nums[i]` with any value in the range `[nums[i+1] - nums[i], nums[i+1]]`.

Return the minimum number of steps required to make the array non-decreasing.

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`

## Example

Input: `nums = [5, 1, 4, 1, 1]`
Output: `3`
