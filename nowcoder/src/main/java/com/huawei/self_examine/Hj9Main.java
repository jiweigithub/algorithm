package com.huawei.self_examine;

import java.util.Scanner;

/**
 * 提取不重复的整数
 * <p>
 * 题目描述
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是0。
 * 输入描述:
 * 输入一个int型整数
 * <p>
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 * <p>
 * 示例1
 * 输入
 * 复制
 * 9876673
 * 输出
 * 复制
 * 37689
 */
public class Hj9Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            solution(input);
        }
    }

    public static void solution(String num) {
        int[] numCount = new int[10];
        char[] chars = num.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            int iVal = chars[i] - '0';
            if (i == chars.length - 1 && iVal == 0) {
                continue;
            } else if (numCount[iVal] == 0) {
                sb.append(iVal);
                numCount[iVal]++;
            }
        }
        System.out.println(sb.toString());
    }
}
