package com.huawei.practise;

import java.util.Scanner;

/**
 * 求连续最大bit数
 *
 * 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 *
 * 本题含有多组样例输入。
 *
 * 输入描述:
 * 输入一个byte数字
 *
 * 输出描述:
 * 输出转成二进制之后连续1的个数
 *
 * 示例1
 * 输入
 * 复制
 * 3
 * 5
 * 输出
 * 复制
 * 2
 * 1
 * 说明
 * 3的二进制表示是11，最多有2个连续的1。
 * 5的二进制表示是101，最多只有1个连续的1。
 */
public class Hj86Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int input = scanner.nextInt();
            String binaryString = Integer.toBinaryString(input);
            int countOne = countOne(binaryString.toCharArray());
            System.out.println(countOne);
        }
    }

    public static int countOne(char[] chars) {
        int maxCount = 0;
        int tempCount = 0;
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == '1') {
                tempCount++;
                maxCount = Math.max(maxCount, tempCount);
                i++;
            } else {
                tempCount = 0;
                i++;
            }
        }
        return maxCount;
    }

}
