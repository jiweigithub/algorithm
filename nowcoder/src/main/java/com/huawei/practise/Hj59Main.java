package com.huawei.practise;

import java.util.*;

/**
 * 题目描述
 * 找出字符串中第一个只出现一次的字符
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入描述:
 * 输入几个非空字符串
 * <p>
 * 输出描述:
 * 输出第一个只出现一次的字符，如果不存在输出-1
 * <p>
 * 示例1
 * 输入
 * asdfasdfo
 * aabb
 * 输出
 * o
 * -1
 */
public class Hj59Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            getFirstOnlyOneChar2(line);
        }
    }

    public static void getFirstOnlyOneChar(String input) {
        char[] chars = input.toCharArray();
        Map<Character, Integer> countMap = new LinkedHashMap<>();
        for (char c : chars) {
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1);
            } else {
                countMap.put(c, 1);
            }
        }
        boolean flag = false;
        Set<Map.Entry<Character, Integer>> entries = countMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                flag = true;
                System.out.println(entry.getKey());
                break;
            }
        }
        if (!flag) {
            System.out.println(-1);
        }
    }

    public static void getFirstOnlyOneChar2(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (input.indexOf(c) == input.lastIndexOf(c)) {
                System.out.println(c);
                break;
            }
            if (i == input.length() - 1) {
                System.out.println(-1);
            }
        }
    }

}
