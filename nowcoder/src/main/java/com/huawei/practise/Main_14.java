package com.huawei.practise;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 字符串的连接最长路径查找（字典序排列字符串）
 *
 * 题目描述
 * 给定n个字符串，请对n个字符串按照字典序排列。
 * 输入描述:
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述:
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 * 示例1
 * 输入
 * 复制
 * 9
 * cap
 * to
 * cat
 * card
 * two
 * too
 * up
 * boat
 * boot
 * 输出
 * 复制
 * boat
 * boot
 * cap
 * card
 * cat
 * to
 * too
 * two
 * up
 */
public class Main_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> outPutList = new ArrayList<>();
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            String input = sc.nextLine();
            outPutList.add(input);
        }
        outPutList.sort(String::compareTo);
        outPutList.forEach(System.out::println);
    }
}
