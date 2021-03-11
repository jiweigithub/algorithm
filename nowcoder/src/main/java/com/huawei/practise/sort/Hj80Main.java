package com.huawei.practise.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 题目描述
 * 题目标题：
 * <p>
 * 将两个整型数组按照升序合并，并且过滤掉重复数组元素。
 * 输出时相邻两数之间没有空格。
 * 请注意本题有多组样例。
 * <p>
 * <p>
 * <p>
 * 输入描述:
 * 输入说明，按下列顺序输入：
 * 1 输入第一个数组的个数
 * 2 输入第一个数组的数值
 * 3 输入第二个数组的个数
 * 4 输入第二个数组的数值
 * <p>
 * 输出描述:
 * 输出合并之后的数组
 * <p>
 * 示例1
 * 输入
 * 3
 * 1 2 5
 * 4
 * -1 0 3 2
 * 输出
 * -101235
 */
public class Hj80Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int count1 = sc.nextInt();
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < count1; i++) {
                set.add(sc.nextInt());
            }
            int count2 = sc.nextInt();
            for (int i = 0; i < count2; i++) {
                set.add(sc.nextInt());
            }
            List<Integer> result = new ArrayList<>(set);
            StringBuilder sb = new StringBuilder();
            for (Integer i : result) {
                sb.append(i);
            }
            System.out.println(sb.toString());
        }
        sc.close();
    }
}
