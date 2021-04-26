package com.huawei.practise;

import java.util.Scanner;

/**
 * 题目描述
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 * <p>
 * 输入描述:
 * 输入两个正整数A和B。
 * <p>
 * 输出描述:
 * 输出A和B的最小公倍数。
 * <p>
 * 示例1
 * 输入
 * 5 7
 * 输出
 * 35
 * <p>
 * 最大公约数 * 最小公倍数 = 两数乘积
 */
public class Hj108Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int result;
            if (m > n) {
                result = (m * n) / gcd(m, n);
            } else {
                result = (m * n) / gcd(n, m);
            }
            System.out.println(result);
        }
    }

    /**
     * 求最大公约数
     *
     * @param m 较大数
     * @param n 较小数
     * @return 最大公约数
     */
    public static int gcd(int m, int n) {
        if (n == 0) {
            return m;
        }
        int r = m % n;
        return gcd(n, r);
    }

}
