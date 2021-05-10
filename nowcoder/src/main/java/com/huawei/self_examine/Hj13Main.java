package com.huawei.self_examine;

import java.util.Scanner;

/**
 * 句子逆序
 * <p>
 * 题目描述
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 * <p>
 * 输入描述:
 * 输入一个英文语句，每个单词用空格隔开。保证输入只包含空格和字母。
 * <p>
 * 输出描述:
 * 得到逆序的句子
 * <p>
 * 示例1
 * 输入
 * 复制
 * I am a boy
 * 输出
 * 复制
 * boy a am I
 */
public class Hj13Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] split = input.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = split.length - 1; i >= 0; i--) {
                stringBuilder.append(split[i] + " " );
            }
            System.out.println(stringBuilder.toString().trim());
        }
    }

}
