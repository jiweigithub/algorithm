package com.shangguigu.algorithm.recursion;

/**
 * 八皇后问题
 */
public class EightQueensSolution {
    //定义一个max表示共有多少个皇后
    int max = 8;
    //定义数组array，保存皇后放置位置的结果
    int[] array = new int[max];
    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        EightQueensSolution solution = new EightQueensSolution();
        solution.check(0);
        System.out.printf("共有：%d解法\n", count);
        System.out.printf("判断冲突的次数共有：%d次", judgeCount);
    }


    /**
     * 查看当我们放置第n个皇后时
     * 就去检测该皇后是否和前面已经摆放的
     * 皇后冲突
     * 用一维数组表示，一维数组的下标代表行数和第几个皇后，对应的数值代表列数,
     * 例如array[0]=0代表，第0行的第0列存在一个皇后，只要有值，就说明有皇后
     * array[1]=4代表，第1行的第4列存在一个皇后
     * 判断当前要放置的皇后是否和前面的皇后冲突
     * ps:由于摆放的时候是一行一行摆放，因此，不用考虑行冲突的情况，只考虑列冲突和对角线冲突即可
     * 1.列冲突，由于下标代表行数，对应的数值代表列数 因此， array[x] = array[y] 说明这两个皇后在同一列
     * 2.对角线冲突，
     * （即将要摆放的皇后的行数-已经摆放好的皇后的行数）的绝对值==（即将要摆放的皇后的列数-已经摆放好的皇后的列数）的绝对值
     * 例如
     * array[1] = 2 说明第一行第二列已经有一个皇后了
     * array[2] = 1 说明要摆放的皇后在第二行第一列 此时就冲突了
     *
     * @param n 表示第n个皇后
     * @return
     */
    public boolean judge(int n) {
        judgeCount++;
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

    /**
     * 放置第n个皇后
     * <p>
     * 特别注意，check是每一次递归，进入到check方法中，都要把8个列都走一遍，因此会有回溯
     */
    public void check(int n) {
        //当n=8时，说明都放好了
        if (n == max) {
            print();
            return;
        }
        //依次放入皇后,并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前皇后放到该行的第1列
            array[n] = i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)) {
                //接着放第n+1个皇后
                check(n + 1);
            }
            //如果冲突，继续将第n个皇后往第i+1列放
        }
    }

    //写一个方法，将皇后摆放的位置打印出来
    public void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.printf("{%d,%d}\t", i, array[i]);
        }
        System.out.println();
    }
}
