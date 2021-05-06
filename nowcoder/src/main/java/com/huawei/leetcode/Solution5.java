package com.huawei.leetcode;

import java.util.Arrays;

/**
 * 最长回文字符串
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

    public static void main(String[] args) {
        String babad = longestPalindrome3("ac");
        System.out.println(babad);
    }

    /**
     * 动态规划求解最长回文子串
     * P(i,j)=P(i+1,j−1)∧(Si==Sj)
     * 边界条件：
     * p(i, i) = true
     * p(i, i+1) = (Si == Si+1)
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    public static String longestPalindrome3(String s) {
        if(s.length() < 2) {
            return s;
        }
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        int maxLen = 1;
        int begin = 0;
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];

            }
        }

        for(int i =0; i<s.length()-1; i++) {
            for(int j=i+1; j<s.length(); j++) {
                if(f[i][j] && j-i +1 > maxLen) {
                    maxLen= j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 中心扩散法
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    /**
     * 暴力解法求取字符串中的最长回文子串
     *
     * @param input
     * @return
     */
    public static String getMaxPalindromicString(String input) {
        //如果字符串长度小于2，直接返回
        if (input.length() < 2) {
            return input;
        }
        //最大回文字串长度 1
        int maxLen = 1;
        //最大回文字串下标起始
        int begin = 0;
        //将输入的字符串转为字符数组
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                int currentMaxLen = j - i + 1;
                //如果当前最大回文字串长度大于maxLen且子串是回文字符串
                if (currentMaxLen > maxLen && isPalindromic(chars, i, j)) {
                    maxLen = currentMaxLen;
                    begin = i;
                }
            }
        }
        return input.substring(begin, begin + maxLen);
    }

    /**
     * 判断一个字符串的字串是否为回文字符串
     *
     * @param chars 字符串数组
     * @param left  子串左边界
     * @param right 子串右边界
     * @return true false
     */
    public static boolean isPalindromic(char[] chars, int left, int right) {
        while (left < right) {
            //如果左边界不等于右边界，则说明该子串不是回文字符串
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
