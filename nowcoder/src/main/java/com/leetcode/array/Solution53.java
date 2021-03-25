package com.leetcode.array;

/**
 * 最大子序和
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 * <p>
 * 输入：nums = [-100000]
 * 输出：-100000
 */
public class Solution53 {

    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = solution53.maxSubArray(nums);
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {

        int currentCount = 0;
        int maxCount = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < currentCount + nums[i]) {
                currentCount = currentCount + nums[i];
            } else {
                currentCount = nums[i];
            }
            if (maxCount < currentCount) {
                maxCount = currentCount;
            }
        }
        return maxCount;
    }
}
