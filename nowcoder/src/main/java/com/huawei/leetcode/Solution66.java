package com.huawei.leetcode;

import java.util.Arrays;

/**
 * 加一
 * <p>
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 * <p>
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 * <p>
 * 输入：digits = [0]
 * 输出：[1]
 */
public class Solution66 {

    public static void main(String[] args) {
        Solution66 solution66 = new Solution66();
        int[] digits = {9, 9};
        int[] ints = solution66.plusOne2(digits);
        System.out.println(Arrays.toString(ints));
    }

    public int[] plusOne(int[] digits) {
        boolean flag = false;
        int mark = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (mark != 1) {
                break;
            } else {
                int val = digits[i];
                if (val == 9) {
                    digits[i] = 0;
                    flag = true;
                } else {
                    digits[i] = digits[i] + 1;
                    flag = false;
                    mark = 0;
                }
            }
        }
        if (flag) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            for (int i = digits.length; i > 0; i--) {
                ans[i] = digits[i - 1];
            }
            return ans;
        } else {
            return digits;
        }
    }


    public int[] plusOne2(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

}
