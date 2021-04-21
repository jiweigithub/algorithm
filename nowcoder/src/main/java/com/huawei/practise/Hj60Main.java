package com.huawei.practise;

import java.util.Scanner;

/**
 * 题目描述
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对。
 * 本题含有多组样例输入。
 * 输入描述:
 * 输入一个偶数
 * <p>
 * 输出描述:
 * 输出两个素数
 * <p>
 * 示例1
 * 输入
 * 20
 * 输出
 * 7
 * 13
 */
public class Hj60Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            printPrime(num);
        }
    }

    public static void printPrime(int num) {
        int x = 0;
        int y = 0;
        int sub = num;
        for (int i = 2; i < num; i++) {
            if (isPrime(i)) {
                int other = num - i;
                if (isPrime(other)) {
                    int abs = Math.abs(i - other);
                    if (abs < sub) {
                        sub = abs;
                        x = i;
                        y = other;
                    }
                }
            }
        }
        System.out.println(x);
        System.out.println(y);
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
