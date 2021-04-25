package com.huawei.practise;

/**
 * 24点游戏算法
 * <p>
 * 题目描述
 * 问题描述：给出4个1-10的数字，通过加减乘除，得到数字为24就算胜利
 * 输入：
 * 4个1-10的数字。[数字允许重复，但每个数字仅允许使用一次，测试用例保证无异常数字。
 * 输出：
 * <p>
 * true or false
 * <p>
 * 本题含有多组样例输入。
 * 输入描述:
 * 输入4个int整数
 * <p>
 * 输出描述:
 * 返回能否得到24点，能输出true，不能输出false
 * <p>
 * 示例1
 * 输入
 * 复制
 * 7 2 1 10
 * 输出
 * 复制
 * true
 */
// package org.jzy.huawei108;

import java.util.Scanner;

public class Hj67Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 初始化数字数组和标志数组
            int[] nums = new int[4];
            int[] signs = new int[4];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = scanner.nextInt();
            }
            // 是否能得到24
            boolean can = false;
            for (int i = 0; i < nums.length; i++) {
                signs[i] = 1;
                if (dfs(nums, signs, nums[i], 24)) {
                    can = true;
                    break;
                }
                signs[i] = 0;
            }
            // 输出结果
            System.out.println(can);
        }
    }

    /**
     * 深度优先算法逻辑
     *
     * @param nums     输入的4个数字
     * @param signs    访问标志数组
     * @param v        顶点的值
     * @param required 需要通过四则运算得到的数字
     * @return
     */
    private static boolean dfs(int[] nums, int[] signs, int v, int required) {
        // 四个角均被访问
        boolean allVisited = true;
        for (int sign : signs) {
            if (sign == 0) {
                allVisited = false;
            }
        }

        if (allVisited) {
            // 在所有节点均被访问的前提下，判断最后的结果是否为所需要的结果。
            return v == required;
        }

        // 访问所有的邻接顶点
        for (int i = 0; i < nums.length; i++) {
            if (signs[i] == 0) {
                signs[i] = 1;
                // 加法
                if (dfs(nums, signs, v + nums[i], required)
                        // 减法
                        || dfs(nums, signs, v - nums[i], required)
                        // 乘法
                        || dfs(nums, signs, v * nums[i], required)
                        /* 除法 */
                        || nums[i] != 0 && v % nums[i] == 0 && dfs(nums, signs, v / nums[i], required)) {
                    // 如果可以通过四则运算得到需要的结果，则返回true。
                    return true;
                }
                // 如果不能通过四则运算得到，则进行回溯。
                signs[i] = 0;
            }
        }
        //当所有情况均得不到需要的结果，返回false。
        return false;
    }
}
