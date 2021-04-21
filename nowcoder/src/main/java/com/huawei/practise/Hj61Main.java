package com.huawei.practise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 放苹果
 * <p>
 * 题目描述
 * 题目描述
 * <p>
 * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
 * <p>
 * 数据范围：0<=m<=10，1<=n<=10。
 * 本题含有多组样例输入。
 * <p>
 * <p>
 * 输入描述:
 * 输入两个int整数
 * <p>
 * 输出描述:
 * 输出结果，int型
 * <p>
 * 示例1
 * 输入
 * 复制
 * 7 3
 * 输出
 * 复制
 * 8
 */
public class Hj61Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] s = line.split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            int i = putAppleDp(m, n);
            System.out.println(i);
        }
    }

    /**
     * 题目关键信息 苹果相同，盘子相同， 允许有盘子为空 且 5，1，1和 1，5，1 认为是1种
     * 分析：
     * 结果方程用f(m,n)表示
     * 1、当苹果数量小于盘子数量 f(m,n) = f(m,m) 例如 1个苹果放到 3个盘子和 1个苹果放到 2个盘子 都只有一种方法
     * 2、当苹果数大于等于盘子数：
     * a、当所有盘子都放了一个苹果时，问题就转换成了 将 m-n个苹果放到n个盘子里，有多少种方法 即： f(m,n) = f(m-n,n)
     * b、当至少有一个盘子为空时，问题就转变成了，将m个苹果放到n-1个盘子里，有多少种方法 即 f(m,n) = f(m,n-1)
     * 我们可以得到状态转换方程
     * f(m,n)  = f(m-n,n) + f(m,n-1)
     * <p>
     * 递归解法
     *
     * @param m
     * @param n
     * @return
     */
    public static int putApple(int m, int n) {
        //当只有一个盘子 或 没有苹果时 只有一种方法
        if (n == 1 || m == 0) {
            return 1;
        }
        //当苹果数小于盘子数时,f(m,n) = f(m,m)
        if (m < n) {
            return putApple(m, m);
        } else {
            return putApple(m - n, n) + putApple(m, n - 1);
        }
    }

    public static int putAppleDp(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        //当只有一个盘子 或 没有苹果时 只有一种方法
        for (int i = 0; i <= m; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i < j) {
                    dp[i][j] = dp[i][i];
                } else {
                    dp[i][j] = dp[i - j][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

}
