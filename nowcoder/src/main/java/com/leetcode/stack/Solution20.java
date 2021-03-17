package com.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = ()
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = ()[]{}
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = (]
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：s = ([)]
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：s = {[]}
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class Solution20 {

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {

        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> dict = new HashMap<>(16);
        dict.put(')', '(');
        dict.put('}', '{');
        dict.put(']', '[');

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (dict.containsKey(aChar)) {
                if (stack.isEmpty() || !stack.peek().equals(dict.get(aChar))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        return stack.isEmpty();
    }

}
