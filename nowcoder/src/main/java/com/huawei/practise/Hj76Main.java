package com.huawei.practise;

import java.util.Scanner;

/**
 *
 * 尼科彻斯定理
 *
 * 题目描述
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 * <p>
 * 例如：
 * <p>
 * 1^3=1
 * <p>
 * 2^3=3+5
 * <p>
 * 3^3=7+9+11
 * <p>
 * 4^3=13+15+17+19
 * <p>
 * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
 * 本题含有多组输入数据。
 * <p>
 * 输入描述:
 * 输入一个int整数
 * <p>
 * 输出描述:
 * 输出分解后的string
 * <p>
 * 示例1
 * 输入
 * 复制
 * 6
 * 输出
 * 复制
 * 31+33+35+37+39+41
 * <p>
 * 等差数列求和公式   Sn = n*a1 + n(n-1)*d/2
 */
public class Hj76Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            long sum = (long) Math.pow(n, 3);
            int a1 = (int) sum / n - (n - 1);
            StringBuilder sb = new StringBuilder(Integer.toString(a1));
            for (int i = 1; i < n; i++) {
                a1 = a1 + 2;
                sb.append("+");
                sb.append(a1);
            }
            System.out.println(sb);
        }
    }
}
