package com.huawei.practise;

import java.util.Scanner;

/**
 * 合唱队
 * <p>
 * 题目描述
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 * <p>
 * 说明：
 * <p>
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，
 * 则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
 * <p>
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 * <p>
 * <p>
 * 注意不允许改变队列元素的先后顺序
 * 请注意处理多组输入输出！
 * <p>
 * 输入描述:
 * 整数N
 * <p>
 * 输出描述:
 * 最少需要几位同学出列
 * <p>
 * 示例1
 * 输入
 * 8
 * 186 186 150 200 160 130 197 200
 * 输出
 * 4
 */
public class Hj24Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            //存储每个数左边小于其的数的个数
            int[] arr1 = new int[n];
            //存储每个数右边小于其的数的个数
            int[] arr2 = new int[n];
            //最左边的数设为1
            arr1[0] = 1;
            //最右边的数设为1
            arr2[n - 1] = 1;
            for (int i = 0; i < n; i++) {
                arr1[i] = 1;
                for (int j = 0; j < i; j++) {
                    //动态规划
                    if (arr[i] > arr[j]) {
                        arr1[i] = Math.max(arr1[j] + 1, arr1[i]);
                    }
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                arr2[i] = 1;
                for (int j = n - 1; j > i; j--) {
                    //动态规划
                    if (arr[i] > arr[j]) {
                        arr2[i] = Math.max(arr2[i], arr2[j] + 1);
                    }
                }
            }

            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                //两个都包含本身
                res[i] = arr1[i] + arr2[i] - 1;
            }
            int max = 1;
            for (int i = 0; i < n; i++) {
                if (res[i] > max) {
                    max = res[i];
                }
            }
            System.out.println(n - max);
        }
    }
}
