package com.huawei.practise;

import java.util.Scanner;

/**
 * 计算某字符出现的次数
 * <p>
 * 题目描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写，字符串长度小于500。
 * <p>
 * 输入描述:
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字母。
 * <p>
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 * <p>
 * 示例1
 * 输入
 * 复制
 * ABCabc
 * A
 * 输出
 * 复制
 * 2
 */
public class Hj2Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String target = scanner.nextLine();
            int count = 0;
            char[] chars = input.toLowerCase().toCharArray();
            char[] chars1 = target.toLowerCase().toCharArray();
            char targetChar = chars1[0];
            for (char c : chars) {
                if (targetChar == c) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

}
