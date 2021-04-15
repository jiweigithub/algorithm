package com.huawei.practise.fibonacci;

import java.util.Scanner;

/**
 * 题目描述
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * <p>
 * 本题有多组数据。
 * <p>
 * 斐波那契数列
 * <p>
 * 输入描述:
 * 输入int型表示month
 * <p>
 * 输出描述:
 * 输出兔子总数int型
 * <p>
 * 示例1
 * 输入
 * 复制
 * 9
 * 输出
 * 复制
 * 34
 */
public class Hj37Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int month = sc.nextInt();
            System.out.println(fibonacci2(month));
        }
    }

    public static long fibonacci(long number) {
        if ((number == 0) || (number == 1)) {
            return number;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }

    /**
     * 动态规划求解斐波那契数列的值
     *
     * @param n
     * @return
     */
    public static long fibonacci2(int n) {
        if (n < 1) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        //定义三个long类型整数
        long a = 1L, b = 1L, c = 0L;
        for (int i = 0; i < n - 2; i++) {
            //第3个数的值等于前两个数的和
            c = a + b;
            //第2个数的值赋值给第1个数
            a = b;
            //第3个数的值赋值给第2个数
            b = c;
        }
        return c;
    }
}
