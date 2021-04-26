package com.huawei.practise;

import java.util.Scanner;

/**
 * 自守数
 * 题目描述
 * 自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n以内的自守数的个数
 */
public class Hj99Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            solution(num);
        }
    }

    public static void solution(int input) {
        int count = 0;
        for (int i = 0; i <= input; i++) {
            long num = i * i;
            String s1 = String.valueOf(i);
            String s = String.valueOf(num);
            if (s.endsWith(s1)) {
                count++;
            }
        }
        System.out.println(count);
    }

}
