package com.huawei.leetcode_1;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 有效括号
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
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：s = "{[]}"
 * 输出：true
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
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        for (char c : chars) {
            //如果当前字符为右括号
            if (pairs.containsKey(c)) {
                //如果栈为空 或者 栈顶元素不等于当前右括号的配对
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(c))) {
                    return false;
                }
                //否则弹出栈顶元素
                stack.pop();
            } else {
                //如果为左括号，压入栈中
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
