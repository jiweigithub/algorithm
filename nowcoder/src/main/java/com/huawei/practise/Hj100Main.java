package com.huawei.practise;

import java.util.Scanner;

/**
 * 等差数列
 * 题目描述
 * 功能:等差数列 2，5，8，11，14。。。。
 * <p>
 * 输入:正整数N >0
 * <p>
 * 输出:求等差数列前N项和
 * <p>
 * 本题为多组输入，请使用while(cin>>)等形式读取数据
 * <p>
 * 输入描述:
 * 输入一个正整数。
 * <p>
 * 输出描述:
 * 输出一个相加后的整数。
 * <p>
 * 示例1
 * 输入
 * 复制
 * 2
 * 输出
 * 复制
 * 7
 */
public class Hj100Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            solution(n);
        }
    }

    public static void solution(int n) {
        int step = 3;
        int result = 0;
        int first = 2;
        for (int i = 0; i < n; i++) {
            result += first + step * i;;
        }
        System.out.println(result);
    }

}
