package com.huawei.practise;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 记负均正
 * <p>
 * 题目描述
 * 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
 * 本题有多组输入用例。
 * 输入描述:
 * 首先输入一个正整数n，
 * 然后输入n个整数。
 * <p>
 * 输出描述:
 * 输出负数的个数，和所有正整数的平均值。
 * <p>
 * 示例1
 * 输入
 * 复制
 * 5
 * 1 2 3 4 5
 * 输出
 * 复制
 * 0 3.0
 */
public class Hj97Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int count = scanner.nextInt();
            int rCount = 0;
            int zCount = 0;
            int sum = 0;
            for (int i = 0; i < count; i++) {
                int num = scanner.nextInt();
                if (num > 0) {
                    zCount++;
                    sum += num;
                }
                if (num < 0) {
                    rCount++;
                }
            }
            BigDecimal bSum = BigDecimal.valueOf(sum);
            BigDecimal bCount = new BigDecimal(1);
            if (zCount != 0) {
                bCount = BigDecimal.valueOf(zCount);
            }
            BigDecimal divide = bSum.divide(bCount, 1, BigDecimal.ROUND_HALF_UP);
            System.out.println(rCount + " " + divide.toString());
        }
    }

}
