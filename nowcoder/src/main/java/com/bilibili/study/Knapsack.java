package com.bilibili.study;

/**
 * 0-1背包问题
 */
public class Knapsack {

    public static void main(String[] args) {
        int N = 6;
        int W = 21;
        int[][] b = new int[N][W];
        opt(b, N, W);
        System.out.println(b[5][20]);
    }

    public static void opt(int[][] b, int N, int W) {
        int[] w = {0, 2, 3, 4, 5, 9};
        int[] v = {0, 3, 4, 5, 8, 10};
        int i, j;
        for (i = 1; i < N; i++) {
            for (j = 1; j < W; j++) {
                if (w[i] > j) {
                    b[i][j] = b[i - 1][j];
                } else {
                    int value1 = b[i - 1][j - w[i]] + v[i];
                    int value2 = b[i - 1][j];
                    b[i][j] = Math.max(value1, value2);
                }
            }
        }
    }
}
