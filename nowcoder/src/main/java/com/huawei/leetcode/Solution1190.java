package com.huawei.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 反转每对括号间的子串
 * <p>
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * <p>
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * <p>
 * 注意，您的结果中 不应 包含任何括号。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 * <p>
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 示例 3：
 * <p>
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 示例 4：
 * <p>
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 */
public class Solution1190 {

    public static void main(String[] args) {
        Solution1190 solution1190 = new Solution1190();
        String s = solution1190.reverseParentheses("(u(love)i)");
        System.out.println(s);
    }

    public String reverseParentheses(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ')') {
                StringBuilder temp = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    Character pop = stack.pop();
                    temp.append(pop);
                }
                stack.pop();
                char[] innerChars = temp.toString().toCharArray();
                for (char ic : innerChars) {
                    stack.push(ic);
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }

}
