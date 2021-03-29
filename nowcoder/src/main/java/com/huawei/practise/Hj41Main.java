package com.huawei.practise;

import java.util.*;

/**
 * 称砝码
 * <p>
 * 题目描述
 * 现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
 * 每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
 * <p>
 * <p>
 * 注：
 * <p>
 * 称重重量包括0
 * <p>
 * <p>
 * 输入描述:
 * 输入包含多组测试数据。
 * <p>
 * 对于每组测试数据：
 * <p>
 * 第一行：n --- 砝码数(范围[1,10])
 * <p>
 * 第二行：m1 m2 m3 ... mn --- 每个砝码的重量(范围[1,2000])
 * <p>
 * 第三行：x1 x2 x3 .... xn --- 每个砝码的数量(范围[1,6])
 * 输出描述:
 * 利用给定的砝码可以称出的不同的重量数
 * <p>
 * 示例1
 * 输入
 * 2
 * 1 2
 * 2 1
 * 输出
 * 5
 */
public class Hj41Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            String[] typeArray = s1.split(" ");
            String[] countArray = s2.split(" ");
            List<Integer> weightList = new ArrayList<>();
            for (int i = 0; i < countArray.length; i++) {
                for (int j = 0; j < Integer.parseInt(countArray[i]); j++) {
                    weightList.add(Integer.parseInt(typeArray[i]));
                }
            }
            Set<Integer> solution = solution(weightList);
            System.out.println(solution.size());
        }
    }

    public static Set<Integer> solution(List<Integer> weightList) {
        //定义结果集合
        Set<Integer> resultSet = new HashSet<>();
        //开始的时候一个砝码都没有放，重量是0;
        resultSet.add(0);
        weightList.forEach(integer -> {
            addWeight(resultSet, integer);
        });
        return resultSet;
    }

    public static void addWeight(Set<Integer> resultSet, Integer weight) {
        Set<Integer> newSet = new HashSet<>();
        resultSet.forEach(integer -> {
            newSet.add(integer);
            newSet.add(integer + weight);
        });
        resultSet.addAll(newSet);
    }
}
