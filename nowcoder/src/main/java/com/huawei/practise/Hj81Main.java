package com.huawei.practise;

import java.util.Scanner;

/**
 * 字符串字符包含
 * <p>
 * 题目描述
 * 判断短字符串中的所有字符是否在长字符串中全部出现。
 * 请注意本题有多组样例输入。
 * <p>
 * <p>
 * <p>
 * 输入描述:
 * 输入两个字符串。第一个为短字符串，第二个为长字符串。两个字符串均由小写字母组成。
 * <p>
 * 输出描述:
 * 如果短字符串的所有字符均在长字符串中出现过，则输出true。否则输出false。
 * <p>
 * 示例1
 * 输入
 * 复制
 * bc
 * abc
 * 输出
 * 复制
 * true
 */
public class Hj81Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String word1 = scanner.nextLine();
            String word2 = scanner.nextLine();
            allOcc(word1, word2);
        }
    }

    public static void allOcc(String word1, String word2) {
        char[] chars = word1.toCharArray();
        char[] chars1 = word2.toCharArray();
        boolean[] charsOcc = new boolean[chars.length];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars1.length; j++) {
                if (chars[i] == chars1[j]) {
                    charsOcc[i] = true;
                }
            }
        }
        boolean flag = true;
        for (boolean flagC : charsOcc) {
            flag = flag && flagC;
        }
        System.out.println(flag);
    }
}
