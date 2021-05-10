package com.huawei.self_examine;

import java.util.Scanner;

/**
 * 取近似值
 * <p>
 * 题目描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。
 * 如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 * <p>
 * 输入描述:
 * 输入一个正浮点数值
 * <p>
 * 输出描述:
 * 输出该数值的近似整数值
 * <p>
 * 示例1
 * 输入
 * 复制
 * 5.5
 * 输出
 * 复制
 * 6
 */
public class Hj7Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextDouble()) {
            double input = scanner.nextDouble();
            long round = Math.round(input);
            System.out.println(round);
        }
    }

}
