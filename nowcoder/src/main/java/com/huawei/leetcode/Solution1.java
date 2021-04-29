package com.huawei.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */
public class Solution1 {

    public static void main(String[] args) {
        towSum2(new int[]{3, 3}, 6);
    }

    public int[] twoSum(int[] nums, int target) {
        //定义一个map，根据 但是，数组中同一个元素在答案里不能重复出现。则 key为数组值
        Map<Integer, Integer> map = new HashMap<>();
        //遍历当前数组
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            //如果map的key中包含目标值减去当前数组值，说明找到了
            if (map.containsKey(val)) {
                //返回当前数组的下标和val对应的下标
                return new int[]{map.get(val), i};
            }
            //如果不包含，则将当前值作key，下标作为val放入map
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] towSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == val && j != i) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
