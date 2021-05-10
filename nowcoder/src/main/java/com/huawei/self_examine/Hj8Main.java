package com.huawei.self_examine;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 合并表记录
 * <p>
 * 题目描述
 * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 * <p>
 * 输入描述:
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 * <p>
 * 输出描述:
 * 输出合并后的键值对（多行）
 * <p>
 * 示例1
 * 输入
 * 复制
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 * 输出
 * 复制
 * 0 3
 * 1 2
 * 3 4
 */
public class Hj8Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int count = Integer.parseInt(scanner.nextLine());
            Map<Integer, Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < count; i++) {
                String line = scanner.nextLine();
                String[] split = line.split(" ");
                int key = Integer.parseInt(split[0]);
                int val = Integer.parseInt(split[1]);
                if (!treeMap.containsKey(key)) {
                    treeMap.put(key, val);
                } else {
                    treeMap.put(key, treeMap.get(key) + val);
                }
            }
            treeMap.forEach((k, v) -> {
                System.out.println(k + " " + v);
            });
        }
    }

}
