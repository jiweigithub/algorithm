package com.huawei.practise;

import java.util.Scanner;

/**
 * 购物单
 * 题目描述
 * 王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，
 * 他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
 * 主件	附件
 * 电脑	打印机，扫描仪
 * 书柜	图书
 * 书桌	台灯，文具
 * 工作椅	无
 * <p>
 * 如果要买归类为附件的物品，必须先买该附件所属的主件。
 * <p>
 * 每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。
 * 王强想买的东西很多，为了不超出预算，他把每件物品规定了一个重要度，分为 5 等：
 * 用整数 1 ~ 5 表示，第 5 等最重要。他还从因特网上查到了每件物品的价格（都是 10 元的整数倍）。
 * 他希望在不超过 N 元（可以等于 N 元）的前提下，使每件物品的价格与重要度的乘积的总和最大。
 * 设第 j 件物品的价格为 v[j] ，重要度为 w[j] ，共选中了 k 件物品，编号依次为 j 1 ， j 2 ，……， j k ，则所求的总和为：
 * v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ … +v[j k ]*w[j k ] 。（其中 * 为乘号）
 * 请你帮助王强设计一个满足要求的购物单。
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入描述:
 * 输入的第 1 行，为两个正整数，用一个空格隔开：N m
 * <p>
 * （其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）
 * <p>
 * <p>
 * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
 * <p>
 * <p>
 * （其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ），
 * q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
 * <p>
 * <p>
 * <p>
 * <p>
 * 输出描述:
 * 输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（ <200000 ）。
 * 示例1
 * 输入
 * 1000 5
 * 800 2 0
 * 400 5 1
 * 300 5 1
 * 400 3 0
 * 500 2 0
 * 输出
 * 2200
 */


public class Hj16Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int n = sc.nextInt();
        if (n <= 0 || money <= 0) {
            System.out.println(0);
        }

        Good[] goods = new Good[n + 1];
        for (int i = 1; i <= n; i++) {
            int v = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            goods[i] = new Good(v, p, q);

            if (q > 0) {
                if (goods[q].a1 == -1) {
                    goods[q].setA1(i);
                } else {
                    goods[q].setA2(i);
                }
            }
        }
        int[][] b = new int[n + 1][money + 1];
        for (int i = 1; i <= n; i++) {
            //主件价值  附件1价值 附件2价值
            int v0 = 0, v1 = 0, v2 = 0;
            int dp0 = 0, dp1 = 0, dp2 = 0, dp3 = 0;
            //附件1下标
            int num1 = goods[i].a1;
            int num2 = goods[i].a2;
            //只有主件时
            v0 = goods[i].v;
            //dp0 = 主件价值*主件权重
            dp0 = v0 * goods[i].p;

            //如果有附件1
            if (num1 != -1) {
                v1 = goods[num1].v;
                dp1 = dp0 + v1 * goods[num1].p;
            }

            //如果有附件2
            if (num2 != -1) {
                v2 = goods[num2].v;
                dp2 = dp0 + v2 * goods[num2].p;
            }

            //既有附件1，又有附件2
            if (num1 != -1 && num2 != -1) {
                dp3 = dp0 + v1 * goods[num1].p + v2 * goods[num2].p;
            }

            for (int j = 0; j <= money; j += 10) {
                //如果当前商品是附件，直接跳过
                if (goods[i].q > 0) {
                    b[i][j] = b[i - 1][j];
                } else {
                    //如果当前商品是主件
                    b[i][j] = b[i - 1][j];
                    if (j >= v0 && v0 != 0) {
                        b[i][j] = Math.max(b[i][j], b[i - 1][j - v0] + dp0);
                    }
                    if (j >= v0 + v1 && v0 + v1 != 0) {
                        b[i][j] = Math.max(b[i][j], b[i - 1][j - v0 - v1] + dp1);
                    }
                    if (j >= v0 + v2 && v0 + v2 != 0) {
                        b[i][j] = Math.max(b[i][j], b[i - 1][j - v0 - v2] + dp2);
                    }
                    if (j >= v0 + v1 + v2 && v0 + v1 + v2 != 0) {
                        b[i][j] = Math.max(b[i][j], b[i - 1][j - v0 - v1 - v2] + dp3);
                    }

                }
            }
        }
        System.out.println(b[n][money]);
    }

    /**
     * 定义物品类
     */
    private static class Good {
        public int v;  //物品的价格
        public int p;  //物品的重要度
        public int q;  //物品的主附件ID

        public int a1 = -1;   //附件1ID
        public int a2 = -1;   //附件2ID

        public Good(int v, int p, int q) {
            this.v = v;
            this.p = p;
            this.q = q;
        }

        public void setA1(int a1) {
            this.a1 = a1;
        }

        public void setA2(int a2) {
            this.a2 = a2;
        }
    }
}
