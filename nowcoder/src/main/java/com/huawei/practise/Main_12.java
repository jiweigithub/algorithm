package com.huawei.practise;

import java.util.Scanner;

/**
 * 字符串反转
 *
 * 题目描述
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 *
 * 输入描述:
 * 输入一行，为一个只包含小写字母的字符串。
 *
 * 输出描述:
 * 输出该字符串反转后的字符串。
 *
 * 示例1
 * 输入
 * 复制
 * abcd
 * 输出
 * 复制
 * dcba
 */
public class Main_12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] chars = line.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
    }

}
