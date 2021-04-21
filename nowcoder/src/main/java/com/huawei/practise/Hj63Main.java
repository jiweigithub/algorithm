package com.huawei.practise;

import java.util.Scanner;

/**
 * DNA序列
 * <p>
 * 题目描述
 * 一个DNA序列由A/C/G/T四个字母的排列组合组成。G和C的比例（定义为GC-Ratio）
 * 是序列中G和C两个字母的总的出现次数除以总的字母数目（也就是序列长度）。
 * 在基因工程中，这个比例非常重要。因为高的GC-Ratio可能是基因的起始点。
 * <p>
 * 给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
 * <p>
 * 本题含有多组样例输入。
 * <p>
 * 输入描述:
 * 输入一个string型基因序列，和int型子串的长度
 * <p>
 * 输出描述:
 * 找出GC比例最高的子串,如果有多个输出第一个的子串
 * <p>
 * 示例1
 * 输入
 * 复制
 * AACTGTGCACGACCTGA
 * 5
 * 输出
 * 复制
 * GCACG
 */
public class Hj63Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            int subLength = Integer.parseInt(scanner.nextLine());
            String s = gcSubString(input, subLength);
            System.out.println(s);
        }
    }

    public static String gcSubString(String input, int subLength) {
        char[] chars = input.toCharArray();
        int maxGCCount = 0;
        int start = 0;
        for (int i = 0; i < input.length() - subLength; i++) {
            int tempCount = 0;
            for (int j = i; j < i + subLength; j++) {
                if (chars[j] == 'G' || chars[j] == 'C') {
                    tempCount++;
                }
            }
            if (maxGCCount < tempCount) {
                start = i;
            }
            maxGCCount = Math.max(maxGCCount, tempCount);
        }
        return input.substring(start, start + subLength);
    }
}
