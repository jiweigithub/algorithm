package com.huawei.practise;

import java.util.Scanner;

/**
 * 统计大写字符个数
 * <p>
 * 题目描述
 * 找出给定字符串中大写字符(即'A'-'Z')的个数。
 * <p>
 * 输入描述:
 * 本题含有多组样例输入
 * 对于每组样例，输入一行，代表待统计的字符串
 * <p>
 * 输出描述:
 * 对于每组样例，输出一个整数，代表字符串中大写字母的个数
 * <p>
 * 示例1
 * 输入
 * 复制
 * add123#$%#%#O
 * 150175017(&^%&$vabovbao
 * 输出
 * 复制
 * 1
 * 0
 */
public class Hj84Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            System.out.println(countUpperCase(input));
        }
    }

    public static int countUpperCase(String input) {
        char[] chars = input.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (Character.isLetter(c) && Character.isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }
}
