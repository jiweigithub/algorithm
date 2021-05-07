package com.huawei.leetcode;

/**
 * 反转字符串中的单词
 * <p>
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 */
public class Solution557 {

    public String reverseWords(String s) {
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            StringBuilder builder = new StringBuilder();
            String word = split[i];
            split[i] = builder.append(word).reverse().toString();
        }
        return String.join(" ", split);
    }
}
