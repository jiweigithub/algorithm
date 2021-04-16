package com.bilibili.study;

import java.util.ArrayList;

/**
 * 动态规划
 * 从数组中选出若干个数字，选出的数字下标不能相邻，求解怎样选结果最大
 */
public class DynamicProgramming {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 1, 7, 8, 3};
        int recOpt = recOpt(arr, arr.length - 1);
        System.out.println(recOpt);
        int dpOpt = dpOpt(arr);
        System.out.println(dpOpt);
    }

    /**
     * 递归方式
     *
     * @param arr
     * @param i   选到数字的下标
     */
    public static int recOpt(int[] arr, int i) {
        int a;
        int b;

        if (i == 0) {
            //递归出口，当i == 0时，直接返回对应的值
            return arr[0];
        } else if (i == 1) {
            //递归出口，当i == 1时，返回 arr[0],arr[1]中较大的值
            return Math.max(arr[0], arr[1]);
        } else {
            //递归处理
            //选当前数字的解 = 当前数字的值 arr[i] + 选第i-2个数字的最优解
            a = recOpt(arr, i - 2) + arr[i];
            //不选当前数字的解 = 选前面第i-1个数字的最优解
            b = recOpt(arr, i - 1);
            //从 A,B解中获取最大的
            return Math.max(a, b);
        }
    }

    public static int dpOpt(int[] arr) {
        ArrayList<Integer>[] optRecords = new ArrayList[arr.length];
        for (int i = 0; i < optRecords.length; i++) {
            optRecords[i] = new ArrayList<>();
        }
        //最优解数组
        int[] opt = new int[arr.length];
        int a;
        int b;
        opt[0] = arr[0];
        optRecords[0].add(arr[0]);
        opt[1] = Math.max(arr[0], arr[1]);
        if (opt[1] == arr[0]) {
            optRecords[1].add(arr[0]);
        } else {
            optRecords[1].add(arr[1]);
        }
        for (int i = 2; i < arr.length; i++) {
            a = opt[i - 2] + arr[i];
            b = opt[i - 1];
            opt[i] = Math.max(a, b);
            if (opt[i] == a) {
                optRecords[i].addAll(optRecords[i - 2]);
                optRecords[i].add(arr[i]);
            } else {
                optRecords[i].addAll(optRecords[i - 1]);
            }
        }
        return opt[arr.length - 1];
    }
}
