package com.huawei.practise.recursion;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 题目描述
 * 输入int型数组，询问该数组能否分成两组，使得两组中各元素加起来的和相等，
 * 并且，所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中（不包括5的倍数）
 * ，能满足以上条件，输出true；不满足时输出false。
 * 本题含有多组样例输入。
 * 输入描述:
 * 第一行是数据个数，第二行是输入的数据
 * <p>
 * 输出描述:
 * 返回true或者false
 * <p>
 * 示例1
 * 输入
 * 4
 * 1 5 -5 1
 * 3
 * 3 5 8
 * 输出
 * true
 * 说明
 * 第一个样例：
 * 第一组：5 -5 1
 * 第二组：1
 * 第二个样例：由于3和5不能放在同一组，所以不存在一种分法。
 */
public class Hj93Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int count = sc.nextInt();
            LinkedList<Integer> inputArray = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                inputArray.add(sc.nextInt());
            }
            int otherSum = 0;
            LinkedList<Integer> otherList = new LinkedList<>();
            int sum3 = 0;
            LinkedList<Integer> list3 = new LinkedList<>();
            int sum5 = 0;
            LinkedList<Integer> list5 = new LinkedList<>();
            Iterator<Integer> iterator = inputArray.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next % 3 == 0) {
                    list3.add(next);
                    sum3 += next;
                } else if (next % 5 == 0) {
                    list5.add(next);
                    sum5 += next;
                } else {
                    otherList.add(next);
                    otherSum += next;
                }
            }
        }
    }
}
