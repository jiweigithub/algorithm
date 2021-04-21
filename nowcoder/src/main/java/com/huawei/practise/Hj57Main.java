package com.huawei.practise;

import java.util.Scanner;

/**
 * 高精度整数加法
 */
public class Hj57Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            System.out.println(plus(a, b));
        }
    }

    public static String plus(String a, String b) {
        char[] chars = a.trim().toCharArray();
        char[] chars1 = b.trim().toCharArray();
        int length = chars.length;
        int length1 = chars1.length;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = length - 1;
        int j = length1 - 1;
        while (i >= 0 || j >= 0) {
            int numi = i >= 0 ? chars[i] - '0' : 0;
            int numj = j >= 0 ? chars1[j] - '0' : 0;
            int num = carry + numi + numj;
            if (num >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            result.append(num % 10);
            if (i >= 0) {
                i--;
            }
            if (j >= 0) {
                j--;
            }
        }
        if (j == -1 && i == -1 && carry > 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
