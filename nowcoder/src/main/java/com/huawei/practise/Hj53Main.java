package com.huawei.practise;

import java.util.Scanner;

/**
 * 杨辉三角变形
 * 1
 * <p>
 * 1  1  1
 * <p>
 * 1  2  3  2  1
 * <p>
 * 1  3  6  7  6  3  1
 * <p>
 * 1  4  10 16 19  16 10  4  1
 * <p>
 * 以上三角形的数阵，第一行只有一个数1，以下每行的每个数，
 * 是恰好是它上面的数，左上角数到右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
 * <p>
 * 求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3。
 * <p>
 * <p>
 * 输入n(n <= 1000000000)
 * 本题有多组输入数据，输入到文件末尾，请使用while(cin>>)等方式读入
 * 输入描述:
 * 输入一个int整数
 * <p>
 * 输出描述:
 * 输出返回的int值
 * <p>
 * 示例1
 * 输入
 * 4
 * 2
 * 输出
 * 3
 * -1
 */
public class Hj53Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {2, 3, 2, 4};
        while (scanner.hasNextLine()) {
            int num = Integer.parseInt(scanner.nextLine());
            if (num < 3) {
                System.out.println(-1);
            } else {
                int index = (num - 2) % 4;
                if (index > 0) {
                    System.out.println(arr[index - 1]);
                } else {
                    System.out.println(arr[arr.length - 1]);
                }
            }
        }
    }
}
