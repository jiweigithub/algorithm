package com.huawei.leetcode;

/**
 * 最后一个单词的长度
 * <p>
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：s = " "
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅有英文字母和空格 ' ' 组成
 */
public class Solution58 {

    public static void main(String[] args) {
        Solution58 solution58 = new Solution58();
        int hello_world = solution58.lengthOfLastWord("a");
        System.out.println(hello_world);
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        String substring = "";
        int spaceIndex = s.lastIndexOf(' ');
        if (spaceIndex >= 0) {
            substring = s.substring(spaceIndex + 1);
        } else {
            substring = s;
        }
        return substring.length();
    }

}
