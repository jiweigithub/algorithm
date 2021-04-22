package com.huawei.practise;

import java.util.Scanner;

/**
 * 题目描述
 * 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
 * 注：子串的定义：将一个字符串删去前缀和后缀（也可以不删）形成的字符串。请和“子序列”的概念分开！
 * <p>
 * 本题含有多组输入数据！
 * 输入描述:
 * 输入两个字符串
 * <p>
 * 输出描述:
 * 返回重复出现的字符
 * 示例1
 * 输入
 * abcdefghijklmnop
 * abcsafjklmnopqrstuvw
 * 输出
 * jklmnop
 */
public class Hj65Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String ss = scanner.nextLine();
            if(str.length()<ss.length()){
                longestSubStringDP(str,ss);
            }else{
                longestSubStringDP(ss,str);
            }
        }
    }

    /**
     * 暴力求解
     *
     * @param a
     * @param b
     */
    public static void longestSubString(String a, String b) {
        String result = "";
        for (int i = 0; i < b.length(); i++) {
            for (int j = i; j < b.length(); j++) {
                String substring = b.substring(i, j + 1);
                if (a.contains(substring) && result.length() < substring.length()) {
                    result = substring;
                }
            }
        }
        System.out.println(result);
    }

    public static void longestSubStringDP(String s,String c) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = c.toCharArray();
        int[][] ins = new int[ch1.length + 1][ch2.length + 1];
        int max = 0;
        int start = 0;
        for (int i = 0; i < ch1.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                if(ch1[i]==ch2[j]){
                    ins[i+1][j+1] = ins[i][j]+1;
                    if(ins[i+1][j+1]>max){
                        max = ins[i+1][j+1];
                        start = i-max;
                    }
                }
            }
        }
        System.out.println(s.substring(start + 1, start + max + 1));
    }
}
