package com.huawei.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 对字符串中的所有单词进行倒排。
 * <p>
 * 说明：
 * <p>
 * 1、构成单词的字符只有26个大写或小写英文字母；
 * <p>
 * 2、非构成单词的字符均视为单词间隔符；
 * <p>
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 * <p>
 * 4、每个单词最长20个字母；
 * <p>
 * 输入描述:
 * 输入一行以空格来分隔的句子
 * <p>
 * 输出描述:
 * 输出句子的逆序
 * <p>
 * 示例1
 * 输入
 * 复制
 * I am a student
 * 输出
 * 复制
 * student a am I
 */
public class Hj31Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            String[] split = input.split("[^a-zA-Z]");
            List<String> resultList = new ArrayList<>();
            for (int i = split.length - 1; i >= 0; i--) {
                if (split[i].length() > 0) {
                    resultList.add(split[i]);
                }
            }
            String join = String.join(" ", resultList);
            System.out.println(join);
        }
    }
}
