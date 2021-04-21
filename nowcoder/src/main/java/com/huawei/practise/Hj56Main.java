package com.huawei.practise;

import java.util.Scanner;

/**
 * 完全数计算
 * <p>
 * 题目描述
 * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
 * <p>
 * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 * <p>
 * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。s
 * <p>
 * 输入n，请输出n以内(含n)完全数的个数。计算范围, 0 < n <= 500000
 * <p>
 * <p>
 * 本题输入含有多组样例。
 * <p>
 * 输入描述:
 * 输入一个数字n
 * <p>
 * 输出描述:
 * 输出不超过n的完全数的个数
 * <p>
 * 示例1
 * 输入
 * 1000
 * 7
 * 100
 * 输出
 * 3
 * 1
 * 2
 */
public class Hj56Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            int count = 0;
            for (int i = 1; i <= num; i++) {
                if (isPerfect(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static boolean isPerfect(int num) {
        int factor = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                factor += i;
            }
        }
        if (factor == num) {
            return true;
        } else {
            return false;
        }
    }

}
