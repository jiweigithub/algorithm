package com.huawei.practise;

import java.util.Scanner;

/**
 * 字符串通配符
 * <p>
 * 题目描述
 * 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
 * 要求：
 * 实现如下2个通配符：
 * *：匹配0个或以上的字符（字符由英文字母和数字0-9组成，不区分大小写。下同）
 * ？：匹配1个字符
 * <p>
 * <p>
 * 输入：
 * 通配符表达式；
 * 一组字符串。
 * <p>
 * <p>
 * 输出：
 * <p>
 * 返回匹配的结果，正确输出true，错误输出false
 * <p>
 * 本题含有多组样例输入！
 * 输入描述:
 * 先输入一个带有通配符的字符串，再输入一个需要匹配的字符串
 * <p>
 * 输出描述:
 * 返回匹配的结果，正确输出true，错误输出false
 * <p>
 * 示例1
 * 输入
 * tx?t*.*
 * txt12.xls
 * 输出
 * false
 */
public class Hj71Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String line1 = scanner.nextLine();
            System.out.println(isMatch(line1,line));
        }
    }

    public static boolean isMatch(String s, String p) {
        int sRight = s.length(), pRight = p.length();
        while (sRight > 0 && pRight > 0 && p.charAt(pRight - 1) != '*') {
            if (charMatch(s.charAt(sRight - 1), p.charAt(pRight - 1))) {
                --sRight;
                --pRight;
            } else {
                return false;
            }
        }

        if (pRight == 0) {
            return sRight == 0;
        }

        int sIndex = 0, pIndex = 0;
        int sRecord = -1, pRecord = -1;

        while (sIndex < sRight && pIndex < pRight) {
            if (p.charAt(pIndex) == '*') {
                ++pIndex;
                sRecord = sIndex;
                pRecord = pIndex;
            } else if (charMatch(s.charAt(sIndex), p.charAt(pIndex))) {
                ++sIndex;
                ++pIndex;
            } else if (sRecord != -1 && sRecord + 1 < sRight) {
                ++sRecord;
                sIndex = sRecord;
                pIndex = pRecord;
            } else {
                return false;
            }
        }

        return allStars(p, pIndex, pRight);
    }

    public static boolean allStars(String str, int left, int right) {
        for (int i = left; i < right; ++i) {
            if (str.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    public static boolean charMatch(char u, char v) {
        return u == v || v == '?';
    }
}
