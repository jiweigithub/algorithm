package com.huawei.self_examine;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 字符个数统计
 * <p>
 * 题目描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。
 * 输入描述:
 * 输入一行没有空格的字符串。
 * <p>
 * 输出描述:
 * 输出范围在(0~127)字符的个数。
 * <p>
 * 示例1
 * 输入
 * 复制
 * abc
 * 输出
 * 复制
 * 3
 */
public class Hj10Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            Set<Character> charSet = new HashSet<>();
            String input = scanner.nextLine();
            char[] chars = input.toCharArray();
            for (char c : chars) {
                if (c >= 0 && c <= 127) {
                    charSet.add(c);
                }
            }
            System.out.println(charSet.size());
        }
    }

}
