package com.huawei.practise;

import java.util.Scanner;

/**
 * 最长回文子串
 * 题目描述
 * 给定一个仅包含小写字母的字符串，求它的最长回文子串的长度。
 * 所谓回文串，指左右对称的字符串。
 * 所谓子串，指一个字符串删掉其部分前缀和后缀（也可以不删）的字符串
 * （注意：记得加上while处理多个测试用例）
 * <p>
 * 输入描述:
 * 输入一个仅包含小写字母的字符串
 * <p>
 * 输出描述:
 * 返回最长回文子串的长度
 * <p>
 * 示例1
 * 输入
 * 复制
 * cdabbacc
 * 输出
 * 复制
 * 4
 * 说明
 * abba为最长的回文子串
 */
public class Hj85Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            getLongestPalindromic(input);
        }
    }

    public static void getLongestPalindromic(String input) {
        char[] chars = input.toCharArray();
        int maxLen = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                int currentMaxLen = j - i + 1;
                //如果当前最大回文字串长度大于maxLen且子串是回文字符串
                if (currentMaxLen > maxLen && isPalindromic(chars, i, j)) {
                    maxLen = currentMaxLen;
                }
            }
        }
        if (maxLen > 0) {
            System.out.println(maxLen);
        }
    }

    /**
     * 判断由左边界起至右边界的一个子串是否为回文字符串
     *
     * @param chars
     * @param left
     * @param right
     * @return
     */
    public static boolean isPalindromic(char[] chars, int left, int right) {
        while (left < right) {
            //如果左边界字符与右边界字符不相等，则不是
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
