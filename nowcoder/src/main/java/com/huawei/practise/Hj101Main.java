package com.huawei.practise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 输入整型数组和排序标识，对其元素按照升序或降序进行排序（一组测试用例可能会有多组数据）
 * <p>
 * 本题有多组输入，请使用while(cin>>)处理
 * <p>
 * 输入描述:
 * 第一行输入数组元素个数
 * 第二行输入待排序的数组，每个数用空格隔开
 * 第三行输入一个整数0或1。0代表升序排序，1代表降序排序
 * <p>
 * 输出描述:
 * 输出排好序的数字
 * <p>
 * 示例1
 * 输入
 * 8
 * 1 2 4 9 3 55 64 25
 * 0
 * 5
 * 1 2 3 4 5
 * 1
 * 输出
 * 1 2 3 4 9 25 55 64
 * 5 4 3 2 1
 */
public class Hj101Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            List<Integer> array = new ArrayList<>();
            int count = sc.nextInt();
            for (int i = 0; i < count; i++) {
                array.add(sc.nextInt());
            }
            int flag = sc.nextInt();
            if (flag == 0) {
                array.sort(Comparator.comparingInt(n -> n));
            } else {
                array.sort((n1, n2) -> n2 - n1);
            }
            StringBuilder sb = new StringBuilder();
            for(Integer item: array) {
                sb.append(item).append(" ");
            }
            System.out.println(sb.toString());
        }
    }

}
