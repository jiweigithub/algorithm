package com.huawei.self_examine;

import java.util.Scanner;

/**
 * 进制转换
 * <p>
 * 题目描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 * <p>
 * 输入描述:
 * 输入一个十六进制的数值字符串。注意：一个用例会同时有多组输入数据，请参考帖子https://www.nowcoder.com/discuss/276处理多组输入的问题。
 * <p>
 * 输出描述:
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 * <p>
 * 示例1
 * 输入
 * 复制
 * 0xA
 * 0xAA
 * 输出
 * 复制
 * 10
 * 170
 */
public class Hj5Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String hexString = input.substring(2);
            Integer integer = Integer.valueOf(hexString, 16);
            System.out.println(integer);
        }
    }

}
