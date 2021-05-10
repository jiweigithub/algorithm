package com.huawei.self_examine;

import java.util.Scanner;

/**
 * 字符串反转
 * <p>
 * 题目描述
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * <p>
 * 输入描述:
 * 输入一行，为一个只包含小写字母的字符串。
 * <p>
 * 输出描述:
 * 输出该字符串反转后的字符串。
 * <p>
 * 示例1
 * 输入
 * 复制
 * abcd
 * 输出
 * 复制
 * dcba
 */
public class Hj12Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            char[] chars = input.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = chars.length - 1; i >= 0; i--) {
                sb.append(chars[i]);
            }
            System.out.println(sb.toString());
        }
    }

}
