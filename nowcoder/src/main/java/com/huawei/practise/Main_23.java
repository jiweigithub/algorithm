package com.huawei.practise;

import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * 删除字符串中出现次数最少的字符
 *
 * 题目描述
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 注意每个输入文件有多组输入，即多个字符串用回车隔开
 * 输入描述:
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *
 * 输出描述:
 * 删除字符串中出现次数最少的字符后的字符串。
 *
 * 示例1
 * 输入
 * 复制
 * abcdd
 * aabcddd
 * 输出
 * 复制
 * dd
 * aaddd
 */
public class Main_23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            char[] chars = input.toCharArray();
            LinkedHashMap<Character, Integer> charMap = new LinkedHashMap<Character, Integer>();
            for (char c : chars) {
                charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            }
            int min = Integer.MAX_VALUE;
            for (Character key : charMap.keySet()) {
                if (min > charMap.get(key)) {
                    min = charMap.get(key);
                }
            }
            StringBuilder res = new StringBuilder();
            for (Character c : chars) {
                if (min != charMap.get(c)) {
                    res.append(c);
                }
            }
            System.out.println(res.toString());
        }
    }
}
