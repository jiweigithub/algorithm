package com.shangguigu.algorithm.recursion;

/**
 * 八皇后问题
 */
public class EightQueensSolution {
    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array，保存皇后放置位置的结果
    int[] array = new int[max];

    public static void main(String[] args) {


    }
    //查看当我们放置第n个皇后时
    //就去检测该皇后是否和前面已经摆放的
    //皇后冲突

    /**
     * @param n 表示第n个皇后
     * @return
     */
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //1.表示第n个皇后是否和前面的n-1个皇后在同一列
            if (array[i] == array[n]
                    //表示判断第n个皇后和第i个皇后是否在同一个斜线
                    || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //写一个方法，将皇后摆放的位置打印出来
    public void print() {
        for (int value : array) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }
}
