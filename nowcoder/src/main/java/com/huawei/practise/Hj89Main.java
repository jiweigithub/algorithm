package com.huawei.practise;

import java.util.*;
import java.lang.*;

/**
 * 题目描述
 * 计算24点是一种扑克牌益智游戏，随机抽出4张扑克牌，通过加(+)，减(-)，乘(*), 除(/)四种运算法则计算得到整数24，本问题中，扑克牌通过如下字符或者字符串表示，其中，小写joker表示小王，大写JOKER表示大王：
 * <p>
 * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
 * <p>
 * 本程序要求实现：输入4张牌，输出一个算式，算式的结果为24点。
 * <p>
 * 详细说明：
 * <p>
 * 1.运算只考虑加减乘除运算，没有阶乘等特殊运算符号，没有括号，友情提醒，整数除法要当心，是属于整除，比如2/3=0，3/2=1；
 * 2.牌面2~10对应的权值为2~10, J、Q、K、A权值分别为为11、12、13、1；
 * 3.输入4张牌为字符串形式，以一个空格隔开，首尾无空格；如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
 * 4.输出的算式格式为4张牌通过+-x/四个运算符相连，中间无空格，4张牌出现顺序任意，只要结果正确；
 * 5.输出算式的运算顺序从左至右，不包含括号，如1+2+3*4的结果为24，2A 9A不能变为(2+1)*(9-1)=24
 * 6.如果存在多种算式都能计算得出24，只需输出一种即可，如果无法得出24，则输出“NONE”表示无解。
 * 7.因为都是扑克牌，不存在单个牌为0的情况，且没有括号运算，除数(即分母)的数字不可能为0
 * <p>
 * 输入描述:
 * 输入4张牌为字符串形式，以一个空格隔开，首尾无空格；
 * <p>
 * 输出描述:
 * 输出怎么运算得到24，如果无法得出24，则输出“NONE”表示无解，如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
 * 示例1
 * 输入
 * 复制
 * A A A A
 * 输出
 * 复制
 * NONE
 * 说明
 * 不能实现
 * 示例2
 * 输入
 * 复制
 * 4 2K A
 * 输出
 * 复制
 * K-A*4/2
 * 说明
 * A+K*2-4也是一种答案，输出任意一种即可
 * 示例3
 * 输入
 * 复制
 * B 5joker 4
 * 输出
 * 复制
 * ERROR
 * 说明
 * 存在joker，输出ERROR
 */
public class Hj89Main {
    private static final String ERROR = "ERROR";

    private static final String NONE = "NONE";

    private static Map<Integer, String> map2 = new HashMap<Integer, String>() {
        {
            put(2, "2");
            put(3, "3");
            put(4, "4");
            put(5, "5");
            put(6, "6");
            put(7, "7");
            put(8, "8");
            put(9, "9");
            put(10, "10");
            put(1, "A");
            put(11, "J");
            put(12, "Q");
            put(13, "K");
        }
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<String, Integer>() {
            {
                put("2", 2);
                put("3", 3);
                put("4", 4);
                put("5", 5);
                put("6", 6);
                put("7", 7);
                put("8", 8);
                put("9", 9);
                put("10", 10);
                put("A", 1);
                put("J", 11);
                put("Q", 12);
                put("K", 13);
                put("joker", 0);
                put("JOKER", 0);
            }
        };

        while (in.hasNext()) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                String str = in.next();
                list.add(map.get(str));
            }

            if (list.contains(0)) {
                System.out.println(ERROR);
            } else {
                String sb = new String("");
                boolean flag = false;
                boolean[] used = new boolean[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    sb = String.valueOf(map2.get(list.get(i)));
                    used[i] = true;
                    if (helper(list, 1, sb, list.get(i), i, used)) {
                        flag = true;
                        break;
                    }
                    used[i] = false;
                }
                if (!flag) {
                    System.out.println(NONE);
                }
            }

        }
    }

    private static boolean helper(List<Integer> list, int cnt, String result, int temp, int i, boolean[] used) {
        if (cnt == 4) {
            if (temp == 24) {
                System.out.println(result);
            }
            return temp == 24;
        }
        for (int j = 0; j < list.size(); j++) {
            if (used[j]) {
                continue;
            }

            used[j] = true;
            int y = list.get(j);
            if (helper(list, cnt + 1, result + "+" + map2.get(y), temp + y, i, used)) {
                return true;
            }

            if (helper(list, cnt + 1, result + "-" + map2.get(y), temp - y, i, used)) {
                return true;
            }

            if (helper(list, cnt + 1, result + "*" + map2.get(y), temp * y, i, used)) {
                return true;
            }

            if (y != 0 && helper(list, cnt + 1, result + "/" + map2.get(y), temp / y, i, used)) {
                return true;
            }
            used[j] = false;

        }
        return false;
    }
}