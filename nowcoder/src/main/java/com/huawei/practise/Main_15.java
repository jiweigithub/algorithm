package com.huawei.practise;

import java.util.Scanner;

/**
 * 十进制转二进制并计算出1的个数
 */
public class Main_15 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        String binaryString = Integer.toBinaryString(input);
        char[] chars = binaryString.toCharArray();
        int countOne = 0;
        for (char c : chars) {
            String s = String.valueOf(c);
            int anInt = Integer.parseInt(s);
            if (anInt == 1) {
                countOne++;
            }
        }
        System.out.println(countOne);
    }
}
