package com.huawei.practise;

import java.util.Scanner;

/**
 * 按字节截取字符串
 * <p>
 * 输入一个字符串和一个整数k，截取字符串的前k个字符并输出
 * 本题输入含有多组数据
 * 输入描述:
 * 第一行输入待截取的字符串
 * <p>
 * <p>
 * 第二行输入一个正整数k，代表截取的长度
 * <p>
 * 输出描述:
 * 截取后的字符串
 * <p>
 * 示例1
 * 输入
 * abABCcDEF
 * 6
 * 输出
 * abABCc
 */
public class Hj46Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int length = Integer.parseInt(scanner.nextLine());
            System.out.println(subString(line, length));
        }
    }

    public static String subString(String input, int length) {
        String result = "";
        char[] chars = input.toCharArray();
        for (int i = 0; i < length; i++) {
            result = result + chars[i];
        }
        return result;
    }
}
