package com.bilibili.study;

import java.util.Arrays;

/**
 * 动态规划，从一组正整数数字中选取若干个数字，
 * 使得结果等于正整数target,如果找不到，返回false
 */
public class DynamicProgramming2 {

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        boolean result = dpSubSet(arr, 13);
        System.out.println(result);
    }

    public static boolean recSubSet(int[] arr, int i, int s) {
        //递归出口, s == 0时, 说明已经找到目标值了
        if (s == 0) {
            return true;
        }
        //递归出口，当i==0 且 arr[0] == s,找到目标值
        if (i == 0) {
            return arr[0] == s;
        }
        //递归出口
        if (arr[i] > s) {
            return recSubSet(arr, i - 1, s);
        }
        //选则当前i
        return recSubSet(arr, i - 1, s - arr[i])
                //不选则当前i
                || recSubSet(arr, i - 1, s);
    }

    public static boolean dpSubSet(int[] arr, int s) {
        boolean[][] subSet = new boolean[arr.length][s + 1];
        for (int i = 0; i < subSet.length; i++) {
            subSet[i][0] = true;
        }
        Arrays.fill(subSet[0], false);
        subSet[0][arr[0]] = true;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < s + 1; j++) {
                if (arr[i] > j) {
                    subSet[i][j] = subSet[i - 1][j];
                } else {
                    boolean a = subSet[i - 1][j - arr[i]];
                    boolean b = subSet[i - 1][j];
                    subSet[i][j] = a || b;
                }
            }

        }
        return subSet[arr.length - 1][s];
    }
}
