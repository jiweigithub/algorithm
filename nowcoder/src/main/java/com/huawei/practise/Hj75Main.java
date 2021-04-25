package com.huawei.practise;

import java.util.Scanner;

/**
 * 公共子串
 *
 * 题目描述
 * 给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
 *
 * 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
 *
 * 输入描述:
 * 输入两个只包含小写字母的字符串
 *
 * 输出描述:
 * 输出一个整数，代表最大公共子串的长度
 *
 * 示例1
 * 输入
 * 复制
 * asdfas
 * werasdfaswer
 * 输出
 * 复制
 * 6
 */
public class Hj75Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String line1 = scanner.nextLine();
            longestSubStringDP(line,line1);
        }
    }


    public static void longestSubStringDP(String s, String c) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = c.toCharArray();
        int[][] ins = new int[ch1.length + 1][ch2.length + 1];
        int max = 0;
        for (int i = 0; i < ch1.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                if (ch1[i] == ch2[j]) {
                    ins[i + 1][j + 1] = ins[i][j] + 1;
                    if (ins[i + 1][j + 1] > max) {
                        max = ins[i + 1][j + 1];
                    }
                }
            }
        }
        System.out.println(max);
    }

}
