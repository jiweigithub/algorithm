package com.huawei.self_examine;

import java.util.Scanner;

/**
 * 数字颠倒
 * <p>
 * 题目描述
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 * <p>
 * <p>
 * 输入描述:
 * 输入一个int整数
 * <p>
 * 输出描述:
 * 将这个整数以字符串的形式逆序输出
 * <p>
 * 示例1
 * 输入
 * 复制
 * 1516000
 * 输出
 * 复制
 * 0006151
 */
public class Hj11Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            char[] chars = input.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                sb.append(chars[i]);
            }
            System.out.println(sb.toString());
        }
    }
}
