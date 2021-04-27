package com.huawei.practise;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * 合并表记录
 */
public class Main_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Integer> inputMap = new TreeMap<>();
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            int key = Integer.parseInt(split[0]);
            int value = Integer.parseInt(split[1]);
            Integer integer = inputMap.get(key);
            if (integer != null) {
                value = value + integer;
            }
            inputMap.put(key, value);
        }
        inputMap.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });
    }
}
