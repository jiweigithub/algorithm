package com.huawei.leetcode_1;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Solution46 {

    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> permute = solution46.permute(nums);
        for (List<Integer> row : permute) {
            System.out.println(row);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        perm(nums, 0, nums.length - 1, ans);
        return ans;
    }

    public void swap(int[] nums, int p, int i) {
        int temp = nums[p];
        nums[p] = nums[i];
        nums[i] = temp;
    }

    public void perm(int[] nums, int p, int q, List<List<Integer>> ans) {
        if (p == q) {
            List<Integer> row = getRow(nums);
            ans.add(row);
        } else {
            for (int i = p; i <= q; i++) {
                swap(nums, p, i);
                perm(nums, p + 1, q, ans);
                swap(nums, p, i);
            }
        }
    }

    public List<Integer> getRow(int[] nums) {
        List<Integer> row = new ArrayList<>();
        for (int val : nums) {
            row.add(val);
        }
        return row;
    }
}
