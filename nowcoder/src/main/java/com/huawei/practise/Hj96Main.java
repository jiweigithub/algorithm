package com.huawei.practise;

import java.util.Scanner;

/**
 * 表示数字
 * <p>
 * 题目描述
 * 将一个字符中所有的整数前后加上符号“*”，其他字符保持不变。连续的数字视为一个整数。
 * <p>
 * 注意：本题有多组样例输入。
 * 输入描述:
 * 输入一个字符串
 * <p>
 * 输出描述:
 * 字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 * <p>
 * 示例1
 * 输入
 * 复制
 * Jkdi234klowe90a3
 * 5151
 * 输出
 * 复制
 * Jkdi*234*klowe*90*a*3*
 * *5151*
 */
public class Hj96Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            join(input, '*');
        }
    }

    public static void join(String input, char x) {
        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            if (Character.isDigit(current)) {
                boolean pre = i - 1 >= 0 && !Character.isDigit(chars[i - 1]) || i == 0;
                //前后都不为数字
                boolean next = i + 1 < chars.length && !Character.isDigit(chars[i + 1]) || i == chars.length - 1;
                if (pre && next) {
                    sb.append(x).append(chars[i]).append(x);
                } else if (pre) {
                    sb.append(x).append(chars[i]);
                } else if (next) {
                    sb.append(chars[i]).append(x);
                } else {
                    sb.append(chars[i]);
                }
            } else {
                sb.append(chars[i]);
            }
        }
        System.out.println(sb.toString());
    }
}
