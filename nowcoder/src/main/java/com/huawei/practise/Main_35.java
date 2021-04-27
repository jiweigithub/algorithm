package com.huawei.practise;

import java.util.Scanner;

/**
 * 蛇形矩阵
 */
public class Main_35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int linCount = sc.nextInt();
            for (int i = 1; i <= linCount; i++) {
                int start = 1 + i * (i - 1) / 2;
                int step = i + 1;
                for (int j = 1; j <= linCount - i + 1; j++) {
                    if (j <= linCount - i) {
                        System.out.print(start + " ");
                    } else {
                        System.out.println(start);
                    }
                    start += step;
                    step++;
                }
            }
        }
    }
}
