package com.huawei.leetcode;

/**
 * 最长回文子串
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 */
public class Solution5 {

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (chars.length < 2) {
            return s;
        }
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                int currentLen = j - i + 1;
                //如果当前最大回文字串长度大于maxLen且子串是回文字符串
                if (currentLen > maxLen && isPalindrome(chars, i, j)) {
                    maxLen = currentLen;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    /**
     * 判断一个字符数组从左下标至右下标是否为回文串
     *
     * @param chars
     * @param left
     * @param right
     * @return
     */
    public boolean isPalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
