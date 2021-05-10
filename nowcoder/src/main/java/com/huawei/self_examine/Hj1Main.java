package com.huawei.self_examine;

import java.util.Scanner;

/**
 * 最后一个单词长度
 * <p>
 * 题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。
 * <p>
 * 输入描述:
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 * <p>
 * 输出描述:
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 * <p>
 * 示例1
 * 输入
 * 复制
 * hello nowcoder
 * 输出
 * 复制
 * 8
 * 说明
 * 最后一个单词为nowcoder，长度为8
 */
public class Hj1Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            int i = input.lastIndexOf(" ");
            System.out.println(input.length() - i);
        }
    }

}
