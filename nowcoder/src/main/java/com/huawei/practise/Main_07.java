package com.huawei.practise;

import java.util.Scanner;

/**
 * 取近似值
 *
 * 题目描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。
 * 如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 *
 * 输入描述:
 * 输入一个正浮点数值
 *
 * 输出描述:
 * 输出该数值的近似整数值
 *
 * 示例1
 * 输入
 * 复制
 * 5.5
 * 输出
 * 复制
 * 6
 */
public class Main_07 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //方法一
        while (sc.hasNextDouble()) {
            double input = sc.nextDouble();
            long round = Math.round(input);
            System.out.println(round);
        }
        //方法二
//        while (sc.hasNextLine()) {
//            String input = sc.nextLine();
//            String[] split = input.split("\\.");
//            long a = Integer.parseInt(split[0]);
//            String b = "0.";
//            if (split.length > 1) {
//                b = b + split[1];
//            }
//            double aDouble = Double.parseDouble(b);
//            if (aDouble >= 0.5) {
//                a++;
//            }
//            System.out.println(a);
//        }
    }

}
