package com.huawei.practise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 数独
 * <p>
 * 题目描述
 * 问题描述：数独（Sudoku）是一款大众喜爱的数字逻辑游戏。
 * 玩家需要根据9X9盘面上的已知数字，推算出所有剩余空格的数字，
 * 并且满足每一行、每一列、每一个粗线宫内的数字均含1-9，并且不重复。
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

    //定义行列以及3*3九宫格使用情况
    static boolean[][] line = new boolean[9][9];
    static boolean[][] column = new boolean[9][9];
    static boolean[][][] block = new boolean[3][3][9];
    static boolean valid = false;
    static List<int[]> spaces = new ArrayList<int[]>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[9][9];
        while (scanner.hasNextLine()) {
            for (int i = 0; i < arr.length; i++) {
                String s = scanner.nextLine();
                s = s.trim();
                String[] s1 = s.split(" ");
                for (int j = 0; j < s1.length; j++) {
                    int num = Integer.parseInt(s1[j]);
                    arr[i][j] = num;
                    //如果是空，则放入spaces中
                    if (arr[i][j] == 0) {
                        spaces.add(new int[]{i, j});
                    } else {
                        //第i行中num已经被使用过了
                        //第j列中num已经被使用过了
                        //在包含i,j的九宫格内num已经被使用过了
                        line[i][num - 1] = column[j][num - 1] = block[i / 3][j / 3][num - 1] = true;
                    }
                }
            }
            sudoku(arr, spaces);
            init();
            printArray(arr);
        }
    }

    private static void init() {
        line = new boolean[9][9];
        column = new boolean[9][9];
        block = new boolean[3][3][9];
        valid = false;
        spaces = new ArrayList<int[]>();
    }

    private static void printArray(int[][] arr) {
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

    /**
     * 求解数独
     *
     * @param arr    待求解数独矩阵
     * @param spaces 未被使用的格子坐标
     */
    public static void sudoku(int[][] arr, List<int[]> spaces) {
        check(arr, spaces, 0);
    }

    public static void check(int[][] array, List<int[]> spaces, int pos) {
        //如果已经放完最后一个位置
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        //得到当前空白位置坐标
        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        //从1至9依次遍历向空白位置放数字
        for (int digit = 0; digit < 9 && !valid; ++digit) {
            //判断当前要放置的数字是否满足要求
            //满足每一行、每一列、每一个粗线宫内的数字均含1-9，并且不重复
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                array[i][j] = digit + 1;
                check(array, spaces, pos + 1);
                //在回溯到当前递归层时，我们还要将
                // line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }

    }
}
