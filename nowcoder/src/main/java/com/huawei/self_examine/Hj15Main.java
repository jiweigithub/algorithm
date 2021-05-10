package com.huawei.self_examine;

import java.util.Scanner;

/**
 * 十进制转二进制并计算出1的个数
 * <p>
 * 题目描述
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 * <p>
 * 输入描述:
 * 输入一个整数（int类型）
 * <p>
 * 输出描述:
 * 这个数转换成2进制后，输出1的个数
 * <p>
 * 示例1
 * 输入
 * 复制
 * 5
 * 输出
 * 复制
 * 2
 */
public class Hj15Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            String binaryString = Integer.toBinaryString(num);
            char[] chars = binaryString.toCharArray();
            int count = 0;
            for (char c : chars) {
                if (c == '1') {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

}
