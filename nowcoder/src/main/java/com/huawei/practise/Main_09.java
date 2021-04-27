package com.huawei.practise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 提取不重复的整数
 */
public class Main_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] chars = line.toCharArray();
        ArrayList<Integer> outPutArray = new ArrayList<>();
        HashSet<Integer> outPutSet = new HashSet<>();
        for (int i = chars.length - 1; i >= 0; i--) {
            String value = String.valueOf(chars[i]);
            int anInt = Integer.parseInt(value);
            if (!outPutSet.contains(anInt)) {
                outPutSet.add(anInt);
                outPutArray.add(anInt);
            }
        }
        StringBuilder outPutString = new StringBuilder("");
        outPutArray.forEach(integer -> {
            outPutString.append(integer);
        });
        System.out.println(outPutString.toString());
    }
}
