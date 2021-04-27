package com.huawei.practise;

import java.util.Scanner;

/**
 * 字符串分隔
 * <p>
 * 题目描述
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * <p>
 * 输入描述:
 * 连续输入字符串(输入多次,每个字符串长度小于100)
 * <p>
 * 输出描述:
 * 输出到长度为8的新字符串数组
 * <p>
 * 示例1
 * 输入
 * abc
 * 123456789
 * 输出
 * abc00000
 * 12345678
 * 90000000
 */
public class Hj4Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            solution(input);
        }
    }

    public static void solution(String input) {
        int length = input.length();
        while (length < 8) {
            input += "0";
            length++;
        }
        String substring = input.substring(0, 8);
        String newInput = input.substring(8);
        System.out.println(substring);
        if (!newInput.equals("")) {
            solution(newInput);
        }
    }

}
