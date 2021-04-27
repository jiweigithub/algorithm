package com.huawei.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 查找兄弟单词
 *
 * 题目描述
 * 定义一个单词的“兄弟单词”为：交换该单词字母顺序，而不添加、删除、修改原有的字母就能生成的单词。
 * 兄弟单词要求和原来的单词不同。例如：ab和ba是兄弟单词。ab和ab则不是兄弟单词。
 * 现在给定你n个单词，另外再给你一个单词str，让你寻找str的兄弟单词里，字典序第k大的那个单词是什么？
 * 注意：字典中可能有重复单词。本题含有多组输入数据。
 * 输入描述:
 * 先输入单词的个数n，再输入n个单词。
 * 再输入一个单词，为待查找的单词x
 * 最后输入数字k
 * 输出描述:
 * 输出查找到x的兄弟单词的个数m
 * 然后输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
 * 示例1
 * 输入
 * 复制
 * 3 abc bca cab abc 1
 * 输出
 * 复制
 * 2
 * bca
 */
public class Hj27Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            String[] split = input.split(" ");
            //单词个数
            int wordCount = Integer.parseInt(split[0]);
            //目标单词
            String targetWord = split[split.length - 2];
            //展示兄弟单词的个数
            int num = Integer.parseInt(split[split.length - 1]);

            List<String> wordList = new ArrayList<>();

            List<String> broWordList = new ArrayList<>();

            for (int i = 1; i <= wordCount; i++) {
                wordList.add(split[i]);
            }

            wordList.sort(String::compareTo);

            wordList.forEach(word -> {
                if (isBroWord(word, targetWord)) {
                    broWordList.add(word);
                }
            });

            System.out.println(broWordList.size());

            if (broWordList.size() >= num) {
                System.out.println(broWordList.get(num - 1));
            }

        }
    }

    private static boolean isBroWord(String word, String targetWord) {
        if (word.length() != targetWord.length()) {
            return false;
        }
        if (word.equals(targetWord)) {
            return false;
        }
        char[] targetChars = targetWord.toCharArray();
        char[] wordChars = word.toCharArray();

        Arrays.sort(targetChars);
        Arrays.sort(wordChars);

        String s1 = new String(targetChars);
        String s2 = new String(wordChars);
        return s1.equals(s2);
    }
}

