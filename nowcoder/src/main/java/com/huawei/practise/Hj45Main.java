package com.huawei.practise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 名字的漂亮程度
 * <p>
 * 题目描述
 * 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
 * <p>
 * 给出多个名字，计算每个名字最大可能的“漂亮度”。
 * <p>
 * 本题含有多组数据。
 * <p>
 * 输入描述:
 * 整数N，后续N个名字
 * <p>
 * 输出描述:
 * 每个名称可能的最大漂亮程度
 * <p>
 * 示例1
 * 输入
 * 复制
 * 2
 * zhangsan = 26+
 * lisi
 * 输出
 * 复制
 * 192
 * 101
 */
public class Hj45Main {

    static int N = 26;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String numString = scanner.nextLine();
            int num = Integer.parseInt(numString);
            String[] names = new String[num];
            for (int i = 0; i < num; i++) {
                String name = scanner.nextLine();
                names[i] = name;
            }
            for (String name : names) {
                System.out.println(solution(name));
            }
        }
    }

    public static int solution(String input) {
        int result = 0;
        input = input.toLowerCase();
        int[] countArray = new int[N];
        char[] chars = input.toCharArray();
        for (char c : chars) {
            countArray[c - 'a']++;
        }
        Arrays.sort(countArray);
        int weight = N;
        for (int i = countArray.length - 1; i >= 0; i--) {
            result += countArray[i] * weight;
            weight--;
        }
        return result;
    }
}
