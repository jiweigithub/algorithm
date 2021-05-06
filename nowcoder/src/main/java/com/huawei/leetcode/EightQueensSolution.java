package com.huawei.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightQueensSolution {

    public List<List<String>> solveNQueens(int n) {
        int[] array = new int[n];
        List<List<String>> solutions = new ArrayList<List<String>>();
        check(solutions,array,0,n);
        return solutions;
    }

    public boolean judge(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            //1.表示第n个皇后是否和第i个皇后在同一列
            if (array[i] == array[n]
                    //表示判断第n个皇后和第i个皇后是否在同一个斜线
                    || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    public void check(List<List<String>> solutions, int[] array, int n, int max) {
        //当n=8时，说明都放好了
        if (n == max) {
            List<String> print = print(array);
            solutions.add(print);
            return;
        }
        //依次放入皇后,并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前皇后放到该行的第1列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(array, n)) {
                //接着放第n+1个皇后
                check(solutions, array, n + 1, max);
            }
            //如果冲突，继续将第n个皇后往第i+1列放
        }
    }

    public List<String> print(int[] array) {
        List<String> board = new ArrayList<String>();
        for (int value : array) {
            char[] row = new char[array.length];
            Arrays.fill(row, '.');
            row[value] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
