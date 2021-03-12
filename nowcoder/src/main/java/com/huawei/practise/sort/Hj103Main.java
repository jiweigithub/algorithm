package com.huawei.practise.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 题目描述
 * Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，但只能从低处往高处的桩子走。他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
 * <p>
 * 本题含有多组样例输入
 * <p>
 * <p>
 * 输入描述:
 * 输入多行，先输入数组的个数，再输入相应个数的整数
 * <p>
 * 输出描述:
 * 输出结果
 * <p>
 * 示例1
 * 输入
 * 复制
 * 6
 * 2 5 1 5 4 5
 * 3
 * 3 2 1
 * 输出
 * 复制
 * 3
 * 1
 * 说明
 * 6个点的高度各为 2 5 1 5 4 5
 * 如从第1格开始走,最多为3步, 2 4 5
 * 从第2格开始走,最多只有1步,5
 * 而从第3格开始走最多有3步,1 4 5
 * 从第5格开始走最多有2步,4 5
 * 所以这个结果是3。
 *
 * 上升子序问题
 */
public class Hj103Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int count = Integer.parseInt(sc.nextLine());
            String input = sc.nextLine();
            String[] split = input.split(" ");
            List<Integer> numList = new ArrayList<>();
            List<Integer> startList = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                numList.add(Integer.parseInt(split[i]));
                startList.add(Integer.parseInt(split[i]));
            }
            int maxStep = 0;
            for (int i = 0; i < startList.size(); i++) {
                Integer start = startList.get(i);
                List<Integer> subList = numList.subList(i, numList.size()).stream().filter(num -> num >= start)
                        .collect(Collectors.toList());
                Map<Integer, Integer> subMap = new HashMap<>();
                for (int j = 0; j < subList.size(); i++) {
                    subMap.put(j, subList.get(j));
                }
                Set<Map.Entry<Integer, Integer>> entries = subMap.entrySet();
                ArrayList<Map.Entry<Integer, Integer>> entryArrayList = new ArrayList<>(entries);
                entryArrayList.sort((o1, o2) -> {
                    if (o2.getValue() - o1.getValue() == 0) {
                        return o1.getKey() - o2.getKey();
                    } else {
                        return o2.getValue() - o1.getValue();
                    }
                });
            }
            System.out.println(maxStep);
        }
    }
}
