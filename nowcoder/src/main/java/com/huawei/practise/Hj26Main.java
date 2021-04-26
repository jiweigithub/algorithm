package com.huawei.practise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *
 * 如，输入： Type 输出： epTy
 *
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *
 * 如，输入： BabA 输出： aABb
 *
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 *
 *
 * 如，输入： By?e 输出： Be?y
 *
 *
 * 注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）
 *
 *
 * 输入描述:
 * 输入字符串
 * 输出描述:
 * 输出字符串
 * 示例1
 * 输入
 * A Famous Saying: Much Ado About Nothing (2012/8).
 * 输出
 * A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 */
public class Hj26Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String input = sc.nextLine();
            char[] chars = input.toCharArray();
            List<Character> letters = new ArrayList<>();
            for (char aChar : chars) {
                if (Character.isLetter(aChar)) {
                    letters.add(aChar);
                }
            }
            letters.sort(Comparator.comparingInt(Character::toLowerCase));

            StringBuilder outPut = new StringBuilder();
            int totalLength = 0;
            for(char c : chars) {
                if(Character.isLetter(c) && totalLength < letters.size()) {
                    outPut.append(letters.get(totalLength));
                    totalLength++;
                } else {
                    outPut.append(c);
                }
            }
            System.out.println(outPut.toString());
        }
    }
}
