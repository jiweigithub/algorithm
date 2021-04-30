package com.huawei.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 字符串解码
 * <p>
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * <p>
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * <p>
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 */
public class Solution394 {

    public static void main(String[] args) {
        Solution394 solution394 = new Solution394();
        String decodeString = solution394.decodeString("2[abc]3[cd]ef");
        System.out.println(decodeString);
    }


    public String decodeString(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            //如果找到右括号
            if (c == ']') {
                //如果栈顶元素不是右括号
                StringBuilder part = new StringBuilder();
                while (stack.peek() != '[') {
                    part.append(stack.pop());
                }
                //弹出左括号
                stack.pop();
                //弹出数字
                StringBuilder numPart = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    numPart.append(stack.pop());
                }
                String numString = numPart.reverse().toString();
                int partCount = Integer.parseInt(numString);
                StringBuilder newPart = new StringBuilder();
                StringBuilder reverse = part.reverse();
                for (int i = 0; i < partCount; i++) {
                    newPart.append(reverse.toString());
                }

                //将新的结果压入栈中
                String newString = newPart.toString();
                char[] newChars = newString.toCharArray();
                for (Character aChar : newChars) {
                    stack.push(aChar);
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }

}
