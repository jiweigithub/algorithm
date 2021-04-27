package com.huawei.practise;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 字符个数统计
 */
public class Main_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] chars = input.toCharArray();
        HashSet<String> outPutSet = new HashSet<>();
        for (char c : chars) {
            if ((int) c >= 0 && (int) c <= 127) {
                outPutSet.add(String.valueOf(c));
            }
        }
        System.out.println(outPutSet.size());
    }
}
