package com.huawei.practise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 矩阵乘法
 * 题目描述
 * 如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其结果将是另一个x行z列的矩阵C。这个矩阵的每个元素是由下面的公式决定的
 * <p>
 * 矩阵的大小不超过100*100
 * 输入描述:
 * 输入包含多组数据，每组数据包含：
 * <p>
 * 第一行包含一个正整数x，代表第一个矩阵的行数
 * <p>
 * 第二行包含一个正整数y，代表第一个矩阵的列数和第二个矩阵的行数
 * <p>
 * 第三行包含一个正整数z，代表第二个矩阵的列数
 * <p>
 * 之后x行，每行y个整数，代表第一个矩阵的值
 * <p>
 * 之后y行，每行z个整数，代表第二个矩阵的值
 * <p>
 * <p>
 * <p>
 * 输出描述:
 * 对于每组输入数据，输出x行，每行z个整数，代表两个矩阵相乘的结果
 * 示例1
 * 输入
 * 2
 * 3
 * 2
 * 1 2 3
 * 3 2 1
 * 1 2
 * 2 1
 * 3 3
 * 输出
 * 14 13
 * 10 11
 */
public class Hj69Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int l = scanner.nextInt();
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] a = new int[l][m];
            int[][] b = new int[m][n];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = scanner.nextInt();
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    b[i][j] = scanner.nextInt();
                }
            }
            int[][] solution = solution(a, b);
            for (int[] arr : solution) {
                for (int num : arr) {
                    System.out.print(num+" ");
                }
                System.out.println();
            }
        }
    }

    public static int[][] solution(int[][] a, int[][] b) {
        //矩阵A行数
        int x = a.length;
        //矩阵A列数|矩阵B行数
        int y = b.length;
        //矩阵B列数
        int z = b[0].length;
        //结果矩阵 行数等于X 列数等于Z
        int[][] result = new int[x][z];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < z; j++) {
                result[i][j] = 0;
                for (int m = 0; m < y; m++) {
                    result[i][j] += a[i][m] * b[m][j];
                }
            }
        }
        return result;
    }

}
