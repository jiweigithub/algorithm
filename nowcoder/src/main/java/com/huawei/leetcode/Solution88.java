package com.huawei.leetcode;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * <p>
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 * <p>
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *  
 */
public class Solution88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0, j = m; i < n && j < m + n; i++, j++) {
            nums1[j] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
