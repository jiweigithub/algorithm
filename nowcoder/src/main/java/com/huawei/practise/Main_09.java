package com.huawei.practise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 提取不重复的整数
 *
 * 题目描述
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是0。
 * 输入描述:
 * 输入一个int型整数
 *
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 示例1
 * 输入
 * 复制
 * 9876673
 * 输出
 * 复制
 * 37689
 */
public class Main_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] chars = line.toCharArray();
        ArrayList<Integer> outPutArray = new ArrayList<>();
        HashSet<Integer> outPutSet = new HashSet<>();
        for (int i = chars.length - 1; i >= 0; i--) {
            String value = String.valueOf(chars[i]);
            int anInt = Integer.parseInt(value);
            if (!outPutSet.contains(anInt)) {
                outPutSet.add(anInt);
                outPutArray.add(anInt);
            }
        }
        StringBuilder outPutString = new StringBuilder("");
        outPutArray.forEach(integer -> {
            outPutString.append(integer);
        });
        System.out.println(outPutString.toString());
    }
}
