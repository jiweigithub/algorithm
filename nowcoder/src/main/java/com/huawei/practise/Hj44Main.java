package com.huawei.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 数独
 * <p>
 * 题目描述
 * 问题描述：数独（Sudoku）是一款大众喜爱的数字逻辑游戏。
 * 玩家需要根据9X9盘面上的已知数字，推算出所有剩余空格的数字，并且满足每一行、每一列、每一个粗线宫内的数字均含1-9，并且不重复。
 * 输入：
 * 包含已知数字的9X9盘面数组[空缺位以数字0表示]
 * 输出：
 * 完整的9X9盘面数组
 * <p>
 * 输入描述:
 * 包含已知数字的9X9盘面数组[空缺位以数字0表示]
 * <p>
 * 输出描述:
 * 完整的9X9盘面数组
 * <p>
 * 示例1
 * 输入
 * 0 9 2 4 8 1 7 6 3
 * 4 1 3 7 6 2 9 8 5
 * 8 6 7 3 5 9 4 1 2
 * 6 2 4 1 9 5 3 7 8
 * 7 5 9 8 4 3 1 2 6
 * 1 3 8 6 2 7 5 9 4
 * 2 7 1 5 3 8 6 4 9
 * 3 8 6 9 1 4 2 5 7
 * 0 4 5 2 7 6 8 3 1
 * 输出
 * 5 9 2 4 8 1 7 6 3
 * 4 1 3 7 6 2 9 8 5
 * 8 6 7 3 5 9 4 1 2
 * 6 2 4 1 9 5 3 7 8
 * 7 5 9 8 4 3 1 2 6
 * 1 3 8 6 2 7 5 9 4
 * 2 7 1 5 3 8 6 4 9
 * 3 8 6 9 1 4 2 5 7
 * 9 4 5 2 7 6 8 3 1
 */
public class Hj44Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[9][9];
        while (scanner.hasNextLine()) {
            List<int[]> spaces = new ArrayList<int[]>();
            for (int i = 0; i < arr.length; i++) {
                String s = scanner.nextLine();
                s = s.trim();
                String[] s1 = s.split(" ");
                for (int j = 0; j < s1.length; j++) {
                    arr[i][j] = Integer.parseInt(s1[j]);
                    //如果是空，则放入spaces中
                    if (arr[i][j] == 0) {
                        spaces.add(new int[]{i, j});
                    }
                }
            }
            sudoku(arr, spaces);
            for (int[] row : arr) {
                for (int i = 0; i < row.length; i++) {
                    if (i < row.length - 1) {
                        System.out.printf("%d ", row[i]);
                    } else {
                        System.out.printf("%d", row[i]);
                    }
                }
                System.out.println();
            }
        }
    }

    public static void sudoku(int[][] arr, List<int[]> spaces) {
        check(arr, spaces, 0);
    }

    /**
     * 判断当前要放置的数字是否满足要求
     * 满足每一行、每一列、每一个粗线宫内的数字均含1-9，并且不重复
     *
     * @param num 将要放置的数字
     * @param x   将要放置的x下标
     * @param y   将要放置的y下标
     * @param arr 数独数组
     * @return 如果重复返回false，如果不重复返回true
     */
    public static boolean judge(int num, int x, int y, int[][] arr) {
        //判断行
        for (int i = 0; i < arr.length; i++) {
            if (arr[x][i] == num) {
                return false;
            }
        }

        //判断列
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][y] == num) {
                return false;
            }
        }

        //判断x,y所在的九宫
        for (int i = (x - x % 3); i < (x - x % 3) + 2; i++) {
            for (int j = (y - y % 3); j < (y - y % 3) + 2; j++) {
                if (arr[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void check(int[][] array, List<int[]> spaces, int pos) {
        //如果已经放完最后一个位置
        if (pos == spaces.size()) {
            return;
        }
        //得到当前空白位置坐标
        int[] posArray = spaces.get(pos);
        int x = posArray[0];
        int y = posArray[1];
        //从1至9依次遍历向空白位置放数字
        for (int num = 1; num < array.length + 1; num++) {
            //如果num在当前位置可以放
            if (judge(num,x, y, array)) {
                array[x][y] = num;
                //继续放下一个位置
                check(array, spaces, pos + 1);
            }
        }
    }
}
