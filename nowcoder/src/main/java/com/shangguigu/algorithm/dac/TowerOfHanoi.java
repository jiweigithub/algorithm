package com.shangguigu.algorithm.dac;

/**
 * 汉诺塔
 */
public class TowerOfHanoi {
    public static void main(String[] args) {
        solutionTowerOfHanoi(64, 'A', 'B', 'C');
    }

    /**
     * 汉诺塔 移动方法
     *
     * @param num
     * @param a   当前塔
     * @param b   中转塔
     * @param c   目标塔
     */
    public static void solutionTowerOfHanoi(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("当前塔" + a + "的第1个盘从" + a + "->" + c);
        } else {
            //如果num>=2,总是看作最下面一个盘和上面的n-1个盘；
            //先把n-1个盘从a->b,移动过程会使用到c
            solutionTowerOfHanoi(num - 1, a, c, b);
            //把最下面的盘从a->c
            System.out.println("当前塔" + a + "的第" + num + "个盘从" + a + "->" + c);
            //把b塔的盘从b->c,移动过程使用到a塔
            solutionTowerOfHanoi(num - 1, b, a, c);
        }
    }
}
