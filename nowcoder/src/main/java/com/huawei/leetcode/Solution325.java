package com.huawei.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 和等于 k 的最长子数组长度
 * <p>
 * 给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长子数组长度。
 * 如果不存在任意一个符合要求的子数组，则返回 0。
 * <p>
 * 注意:
 *  nums 数组的总和是一定在 32 位有符号整数范围之内的。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1, -1, 5, -2, 3], k = 3
 * 输出: 4
 * 解释: 子数组 [1, -1, 5, -2] 和等于 3，且长度最长。
 * 示例 2:
 * <p>
 * 输入: nums = [-2, -1, 2, 1], k = 1
 * 输出: 2
 * 解释: 子数组 [-1, 2] 和等于 1，且长度最长。
 */
public class Solution325 {

    /**
     * 暴力搜索，会超时
     *
     * @param nums
     * @param k
     * @return
     */
    public int violenceSearch(int[] nums, int k) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int currentLen = j - i + 1;
                if (bingo(nums, i, j, k)) {
                    if (maxLen < currentLen) {
                        maxLen = currentLen;
                    }
                }
            }
        }
        return maxLen;
    }

    public boolean bingo(int[] nums, int left, int right, int k) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum == k;
    }

    /**
     * 设 sum[i] 表示 nums[0] + nums[1] + ... + nums[i-1] 的和，称为第 i 位的前缀和。
     * <p>
     * 于是，如果存在两个索引 i 和 j，使得 sum[j] - sum[i] == k，说明找到一个子数组 [i, j-1] ，子数组的和为 k。
     * <p>
     * 定义一个 HashMap ，把 sum[i] 作为 key ，把 i 作为 value。如果有相同的 sum[i] ，我们保存 i 最小的那个。
     * <p>
     * 从 i == sum.length-1 开始遍历 map：
     * <p>
     * 遍历到的为 sum[i] ,如果在 map 中存在 sum[i]-k ，说明存在一个长度为 k 的子数组，
     * 现在我们得找到这个子数组的起始索引，即 map.get(sum[i]-k)，于是我们统计从 map.get(sum[i]-k) 到 i-1 长度为，并更新 maxLength。
     *
     * @param nums
     * @param k
     * @return
     */
    public int maxSubArrayLen(int[] nums, int k) {
        int length = nums.length;
        int[] sum = new int[length + 1];
        Map<Integer, Integer> sumMap = new HashMap<>(16);
        sum[0] = 0;
        sumMap.put(sum[0], 0);
        // sum[i] 表示从第 0 个元素到第 i 个元素的所有元素之和
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            // 把 sum[i] 的值作为 key，索引 i 作为 value 存储到 HashMap 中
            if (!sumMap.containsKey(sum[i])) {
                sumMap.put(sum[i], i);
            }
        }
        // 初始最大长度为 0
        int maxLength = 0;
        // 从 i = length-1 开始往前遍历 map ，
        for (int i = length; i > maxLength; i--) {
            // 假设遍历到 key == sum[i] ，如果 map 中存在 key == sum[i] - k，说明找到一个子数组和为 k
            if (sumMap.containsKey(sum[i] - k)) {
                // 长度为：map.get(sum[i]) - map.get(sum[i]-k)
                // map.get(sum[i]) 就是 i
                maxLength = Math.max(maxLength, i - sumMap.get(sum[i] - k));
            }
        }
        return maxLength;

    }


    public int maxSubArrayLen2(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            sum = sum + nums[i];
            //相当于窗口右移一位
            if (sum == k) {
                ans = i + 1;
                //有可能就是答案
            }
            if (map.containsKey(sum - k)) {
                ans = Math.max(ans, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
                //后面再遇到的不用加进去，因为长度肯定大，我们要比较小的，因为这个东西是要被减去的。
            }
        }
        return ans;
    }
}
