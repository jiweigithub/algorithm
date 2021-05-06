package com.huawei.leetcode;

/**
 * 回文数
 * <p>
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 * <p>
 * 输入：x = -101
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 *  
 * <p>
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 */
public class Solution9 {

    /**
     * 字符串反转对比
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x);
        String input = stringBuilder.toString();
        String reverseInput = stringBuilder.reverse().toString();
        return input.equals(reverseInput);
    }

    /**
     * 数字反转对比
     *
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        //当x为负数时，直接判断不是回文数
        //当x的最后一位为0，切x不为0时，一定不是回文数
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revers = 0;
        //只反一半
        while (x > revers) {
            //获取反转后的结果
            revers = revers * 10 + x % 10;
            x = x / 10;
        }
        return x == revers || x == revers / 10;
    }

}
