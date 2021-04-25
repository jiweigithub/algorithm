package com.huawei.practise;

import java.util.Scanner;

/**
 * 二维数组操作
 */
public class Hj83Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            StringBuilder result = new StringBuilder();
            String line = scanner.nextLine();
            String[] s = line.split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            if (m > 9 || n > 9) {
                result.append(-1).append("\n");
            } else {
                result.append(0).append("\n");
                int[][] arr = new int[m][n];
                String line1 = scanner.nextLine();
                String[] s1 = line1.split(" ");
                int x1 = Integer.parseInt(s1[0]);
                int y1 = Integer.parseInt(s1[1]);
                int x2 = Integer.parseInt(s1[2]);
                int y2 = Integer.parseInt(s1[3]);
                if (x1 >= m || y1 >= n || x2 >= m || y2 >= n) {
                    result.append(-1).append("\n");
                } else {
                    result.append(0).append("\n");
                    int temp = arr[x1][y1];
                    arr[x1][y1] = arr[x2][y2];
                    arr[x2][y2] = temp;
                }
                int i = Integer.parseInt(scanner.nextLine());
                if (m + 1 > 9 || i>=m) {
                    result.append(-1).append("\n");
                } else {
                    result.append(0).append("\n");
                }
                int i1 = Integer.parseInt(scanner.nextLine());
                if (n + 1 > 9 || i1>=n) {
                    result.append(-1).append("\n");
                } else {
                    result.append(0).append("\n");
                }
                String line2 = scanner.nextLine();
                String[] s2 = line2.split(" ");
                int j = Integer.parseInt(s2[0]);
                int j1 = Integer.parseInt(s2[1]);
                if (j >= m || j1 >= n) {
                    result.append(-1);
                } else {
                    result.append(0);
                }
            }
            System.out.print(result.toString());
            System.out.println();
        }
    }
}
