package com.huawei.practise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 输入n个整数，输出其中最小的k个。
 * <p>
 * 本题有多组输入样例，请使用循环读入，比如while(cin>>)等方式处理
 * 输入描述:
 * 第一行输入两个整数n和k
 * 第二行输入一个整数数组
 * <p>
 * 输出描述:
 * 输出一个从小到大排序的整数数组
 * <p>
 * 示例1
 * 输入
 * 复制
 * 5 2
 * 1 3 5 7 2
 * 输出
 * 复制
 * 1 2
 */
public class Hj58Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] l = line.split(" ");
            int count = Integer.parseInt(l[0]);
            int k = Integer.parseInt(l[1]);
            int[] arr = new int[count];
            String line1 = scanner.nextLine();
            String[] s = line1.split(" ");
            for (int i = 0; i < count; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            Arrays.sort(arr);
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < k; i++) {
                if (i < k - 1) {
                    result.append(arr[i]).append(" ");
                } else {
                    result.append(arr[i]);
                }
            }
            System.out.println(result.toString());
        }
    }
}
