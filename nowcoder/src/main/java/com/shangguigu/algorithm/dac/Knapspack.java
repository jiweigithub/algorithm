package com.shangguigu.algorithm.dac;

/**
 * 0-1背包问题
 */
public class Knapspack {

    public static void main(String[] args) {
        //物品重量
        int[] w = {2, 3, 4, 5, 9};
        //物品价值
        int[] val = {3, 4, 5, 8, 10};
        //背包容量
        int m = 20;
        //物品的个数
        int n = val.length;
        //v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n + 1][m + 1];
        int[][] path = new int[n + 1][m + 1];

        //初始化第一行第一列
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }

        //进行动态规划
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    int value1 = v[i - 1][j - w[i - 1]] + val[i - 1];
                    int value2 = v[i - 1][j];
                    if (value1 > value2) {
                        path[i][j] = 1;
                    }
                    v[i][j] = Math.max(value1, value2);
                }
            }
        }
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        for (int h = 0; h < path.length; h++) {
            for (int k = 0; k < path.length; k++) {
                System.out.print(path[h][k]+" ");
            }
            System.out.println();
        }

        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= w[i - 1];
            }
            i--;
        }
    }
}
