package com.huawei.practise;

import java.util.Scanner;

/**
 * 字符串加解密
 *
 * 题目描述
 * 1、对输入的字符串进行加解密，并输出。
 *
 * 2、加密方法为：
 *
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 *
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 *
 * 其他字符不做变化。
 *
 * 3、解密方法为加密的逆过程。
 *
 *
 * 本题含有多组样例输入。
 * 输入描述:
 * 输入说明
 * 输入一串要加密的密码
 * 输入一串加过密的密码
 *
 * 输出描述:
 * 输出说明
 * 输出加密后的字符
 * 输出解密后的字符
 *
 * 示例1
 * 输入
 * 复制
 * abcdefg
 * BCDEFGH
 */
public class Main_29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String encryptString = sc.nextLine();
            String unEncryptString = sc.nextLine();
            System.out.println(encrypt(encryptString));
            System.out.println(unEncrypt(unEncryptString));
        }

    }

    public static String encrypt(String inputString) {
        StringBuilder builder = new StringBuilder();
        char[] chars = inputString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] < 'z') {
                int asciiCode = chars[i];
                chars[i] = Character.toUpperCase((char) (asciiCode + 1));
                continue;
            }
            if (chars[i] == 'z') {
                chars[i] = 'A';
                continue;
            }
            if (chars[i] >= 'A' && chars[i] < 'Z') {
                int asciiCode = chars[i];
                chars[i] = Character.toLowerCase((char) (asciiCode + 1));
                continue;
            }
            if (chars[i] == 'Z') {
                chars[i] = 'a';
                continue;
            }
            if (chars[i] >= '0' && chars[i] < '9') {
                int asciiCode = chars[i];
                chars[i] = (char) (asciiCode + 1);
                continue;
            }
            if (chars[i] == '9') {
                chars[i] = '0';
                continue;
            }
        }
        builder.append(chars);
        return builder.toString();
    }

    public static String unEncrypt(String inputString) {
        StringBuilder builder = new StringBuilder();
        char[] chars = inputString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 'a' && chars[i] <= 'z') {
                int asciiCode = chars[i];
                chars[i] = Character.toUpperCase((char) (asciiCode - 1));
                continue;
            }
            if (chars[i] == 'a') {
                chars[i] = 'Z';
                continue;
            }
            if (chars[i] > 'A' && chars[i] <= 'Z') {
                int asciiCode = chars[i];
                chars[i] = Character.toLowerCase((char) (asciiCode - 1));
                continue;
            }
            if (chars[i] == 'A') {
                chars[i] = 'z';
                continue;
            }
            if (chars[i] > '0' && chars[i] <= '9') {
                int asciiCode = chars[i];
                chars[i] = (char) (asciiCode - 1);
                continue;
            }
            if (chars[i] == '0') {
                chars[i] = '9';
                continue;
            }
        }
        builder.append(chars);
        return builder.toString();
    }
}
