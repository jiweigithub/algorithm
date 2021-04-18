package com.leetcode;

import java.util.ArrayList;

/**
 * 最大连续子序和
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
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(dpOpt2(nums));
    }

    public static int dpOpt(int[] nums) {
        int pre = nums[0], maxAns = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            System.out.printf(" 取到第%d个数的时候,和的最大值%d\n", i + 1, pre);
            if (nums[i] == pre) {
                System.out.println("开始下标为：" + i);
            }
            maxAns = Math.max(maxAns, pre);
            if (pre == maxAns) {
                System.out.println("结束下标为：" + i);
            }
        }
        return maxAns;
    }

    /**
     * 动态规划解法2
     * 当 i = 0 时 f(i) = nums[0]
     * 当 i > 0 时 f(i) = max{f(i-1)+nums[i],nums[i]}
     *
     * @param nums
     * @return
     */
    public static int dpOpt2(int[] nums) {

        ArrayList<Integer>[] optRecords = new ArrayList[nums.length];
        for (int i = 0; i < optRecords.length; i++) {
            optRecords[i] = new ArrayList<>();
        }

        int[] opt = new int[nums.length];

        //当i=0时
        opt[0] = nums[0];
        optRecords[0].add(nums[0]);
        //当i大于0时 f(i) = max{f(i-1)+nums[i],nums[i]}
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            opt[i] = Math.max(opt[i - 1], pre);
            if (opt[i] == pre) {
                optRecords[i].addAll(optRecords[i - 1]);
                optRecords[i].add(nums[i]);
            } else {
                optRecords[i].addAll(optRecords[i - 1]);
            }
        }
        return opt[nums.length - 1];
    }
}
