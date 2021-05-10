package com.huawei.practise;

import java.util.Scanner;

/**
 * 十进制转二进制并计算出1的个数
 *
 * 题目描述
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 *
 * 输入描述:
 *  输入一个整数（int类型）
 *
 * 输出描述:
 *  这个数转换成2进制后，输出1的个数
 *
 * 示例1
 * 输入
 * 复制
 * 5
 * 输出
 * 复制
 * 2
 */
public class Main_15 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        String binaryString = Integer.toBinaryString(input);
        char[] chars = binaryString.toCharArray();
        int countOne = 0;
        for (char c : chars) {
            String s = String.valueOf(c);
            int anInt = Integer.parseInt(s);
            if (anInt == 1) {
                countOne++;
            }
        }
        System.out.println(countOne);
    }
}
