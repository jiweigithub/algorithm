package com.huawei.practise;

import java.util.Scanner;

/**
 * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数
 * <p>
 * 题目描述
 * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
 * <p>
 * 本题包含多组输入。
 * <p>
 * <p>
 * 输入描述:
 * 输入一行字符串，可以有空格
 * <p>
 * 输出描述:
 * 统计其中英文字符，空格字符，数字字符，其他字符的个数
 * <p>
 * 示例1
 * 输入
 * 复制
 * 1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\][
 * 输出
 * 26
 * 3
 * 10
 * 12
 */
public class Hj40Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            solution(input);
        }
    }


    public static void solution(String input) {
        int letterCount = 0;
        int spaceCount = 0;
        int numCount = 0;
        int otherCount = 0;
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (Character.isLetter(c)) {
                letterCount++;
            } else if (Character.isDigit(c)) {
                numCount++;
            } else if (Character.isWhitespace(c)) {
                spaceCount++;
            } else {
                otherCount++;
            }
        }
        System.out.println(letterCount);
        System.out.println(spaceCount);
        System.out.println(numCount);
        System.out.println(otherCount);
    }
}
