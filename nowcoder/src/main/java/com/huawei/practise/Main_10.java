package com.huawei.practise;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 字符个数统计
 *
 * 题目描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 * 例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。
 * 输入描述:
 * 输入一行没有空格的字符串。
 *
 * 输出描述:
 * 输出范围在(0~127)字符的个数。
 *
 * 示例1
 * 输入
 * 复制
 * abc
 * 输出
 * 复制
 * 3
 */
public class Main_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] chars = input.toCharArray();
        HashSet<String> outPutSet = new HashSet<>();
        for (char c : chars) {
            if ((int) c >= 0 && (int) c <= 127) {
                outPutSet.add(String.valueOf(c));
            }
        }
        System.out.println(outPutSet.size());
    }
}
