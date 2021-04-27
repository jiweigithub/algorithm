package com.huawei.practise;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 字符串的连接最长路径查找（字典序排列字符串）
 */
public class Main_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> outPutList = new ArrayList<>();
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            String input = sc.nextLine();
            outPutList.add(input);
        }
        outPutList.sort(String::compareTo);
        outPutList.forEach(System.out::println);
    }
}
