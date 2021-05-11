package com.huawei.practise;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 在字符串中找出最长连续数字串
 *
 * 题目描述
 * 输入一个字符串，返回其最长的数字子串，以及其长度。若有多个最长的数字子串，则将它们全部输出（按原字符串的相对位置）
 * 本题含有多组样例输入。
 *
 * 输入描述:
 * 输入一个字符串。
 *
 * 输出描述:
 * 输出字符串中最长的数字字符串和它的长度，中间用逗号间隔。如果有相同长度的串，则要一块儿输出（中间不要输出空格）。
 *
 * 示例1
 * 输入
 * 复制
 * abcd12345ed125ss123058789
 * a8a72a6a5yy98y65ee1r2
 * 输出
 * 复制
 * 123058789,9
 * 729865,2
 */
public class Hj92Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            List<String> beginList = new ArrayList<>();
            int longestNumStr = getLongestNumStr(input, beginList);
            List<String> collect = beginList.stream().filter(item -> item.length() == longestNumStr).collect(Collectors.toList());
            StringBuilder result = new StringBuilder();
            for (String s : collect) {
                result.append(s);
            }
            System.out.println(result.toString() + "," + longestNumStr);
        }
    }

    public static int getLongestNumStr(String input, List<String> beginList) {
        int maxCount = 0;
        int tempCount = 0;
        int i = 0;
        int begin = 0;
        while (i < input.length()) {
            if (Character.isDigit(input.charAt(i))) {
                tempCount++;
                if (maxCount <= tempCount) {
                    maxCount = tempCount;
                    begin = i - maxCount + 1;
                    beginList.add(input.substring(begin, begin + maxCount));
                }
            } else {
                tempCount = 0;
            }
            i++;
        }
        return maxCount;
    }
}
