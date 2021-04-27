package com.huawei.practise;

/**
 * 题目描述
 * 按照指定规则对输入的字符串进行处理。
 *
 * 详细描述：
 *
 * 将输入的两个字符串合并。
 *
 * 对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标意思是字符在字符串中的位置。
 *
 * 对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’； 如字符为‘7’，为0111b，则翻转后为1110b，也就是e。转换后的字符为大写‘E’。
 *
 *
 * 举例：输入str1为"dec"，str2为"fab"，合并为“decfab”，分别对“dca”和“efb”进行排序，排序后为“abcedf”，转换后为“5D37BF”
 *
 * 注意本题含有多组样例输入
 *
 *
 * 输入描述:
 * 本题含有多组样例输入。每组样例输入两个字符串，用空格隔开。
 *
 * 输出描述:
 * 输出转化后的结果。每组样例输出一行。
 *
 * 示例1
 * 输入
 * 复制
 * dec fab
 * 输出
 * 复制
 * 5D37BF
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 字符串合并处理
 */
public class Hj30Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            String replace = input.replace(" ", "");
            char[] chars = replace.toCharArray();
            List<Character> evens = new LinkedList<>();
            List<Character> odds = new LinkedList<>();
            for (int i = 0; i < chars.length; i++) {
                if (i % 2 == 0) {
                    evens.add(chars[i]);
                } else {
                    odds.add(chars[i]);
                }
            }
            evens.sort(Character::compareTo);
            odds.sort(Character::compareTo);

            char[] resultChars = new char[chars.length];

            for (int i = 0; i < chars.length; i++) {
                if (i % 2 == 0) {
                    if (evens.size() > 0) {
                        Character character = evens.get(0);
                        resultChars[i] = character;
                        evens.remove(0);
                    }
                }
            }
            for (int i = 0; i < chars.length; i++) {
                if (i % 2 != 0) {
                    if (odds.size() > 0) {
                        Character character = odds.get(0);
                        resultChars[i] = character;
                        odds.remove(0);
                    }
                }
            }

            StringBuilder builder = new StringBuilder();
            for (char c : resultChars) {
                builder.append(c);
            }
            System.out.println(reverseStr(builder.toString()));
        }
    }


    public static String reverseStr(String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        char[] nums = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : nums) {
            if (c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F' || c >= '0' && c <= '9') {
                String bStr = binaryString(Integer.valueOf(c + "", 16));
                StringBuilder temp = new StringBuilder(bStr);
                String oxStr = temp.reverse().toString();
                String res = Integer.toHexString(Integer.parseInt(oxStr, 2)).toUpperCase();
                sb.append(res);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static String binaryString(int num) {
        StringBuilder result = new StringBuilder();
        int flag = 1 << 3;
        for (int i = 0; i < 4; i++) {
            int val = (flag & num) == 0 ? 0 : 1;
            result.append(val);
            num <<= 1;
        }
        return result.toString();
    }
}

