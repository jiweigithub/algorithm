package com.bilibili.study;

/**
 * 0-1背包问题 v表示物品价值，n表示背包剩余容量， w表示物品重量
 * <p>
 * 状态转移方程，将第i件物品放到容量为n的背包中：
 * 1、如果不放第i件物品,问题会转变成 将前i-1件物品放到容量为n的背包中=> f[i][n] = f[i-1][n]
 * 2、如果放第i件物品，问题会转变成,将前i-1件物品放到容量为n-w[i]的背包中 => f[i][n] = f[i-1][n-w[i]] + v[i];
 * 则 f[i][n] = max {f[i-1][n],f[i-1][n-w[i]] + v[i]};
 */
public class Knapsack2 {

    public static void main(String[] args) {
        int N = 6;
        int W = 21;
        int[][] b = new int[N][W];
        opt(b, N, W);
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(b[5][20]);
    }

    public static void opt(int[][] b, int N, int W) {
        int[] w = {0, 2, 3, 4, 5, 9};
        int[] v = {0, 3, 4, 5, 8, 10};
        int[][] path = new int[N][W];
        int i, j;
        for (i = 1; i < N; i++) {
            for (j = 1; j < W; j++) {
                if (w[i] > j) {
                    b[i][j] = b[i - 1][j];
                } else {
                    int value1 = b[i - 1][j - w[i]] + v[i];
                    int value2 = b[i - 1][j];
                    if (value1 > value2) {
                        path[i][j] = 1;
                    }
                    b[i][j] = Math.max(value1, value2);
                }
            }
        }
        for (int m = 0; m < path.length; m++) {
            for (int n = 0; n < path.length; n++) {
                System.out.print(path[m][n] + " ");
            }
            System.out.println();
        }
        int x = path.length - 1;
        int y = path[0].length - 1;
        while (x > 0 && y > 0) {
            if (path[x][y] == 1) {
                System.out.printf("第%d个商品放入到背包\n", x);
                y -= w[x];
            }
            x--;
        }
    }
}
