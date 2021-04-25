package com.huawei.practise;

import java.util.Scanner;

/**
 * 走格子的方案数
 * 题目描述
 * 请计算n*m的棋盘格子（n为横向的格子数，m为竖向的格子数）
 * 沿着各自边缘线从左上角走到右下角，总共有多少种走法，
 * 要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
 * <p>
 * 本题含有多组样例输入。
 * 输入描述:
 * 每组样例输入两个正整数n和m，用空格隔开。(1≤n,m≤8)
 * <p>
 * 输出描述:
 * 每组样例输出一行结果
 * <p>
 * 示例1
 * 输入
 * 复制
 * 2 2
 * 1 2
 * 输出
 * 复制
 * 6
 * 3
 */
public class Hj91Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] s = input.split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            System.out.println(dp(m, n));
        }
    }

    public static int dp(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        //初始化dp
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}
