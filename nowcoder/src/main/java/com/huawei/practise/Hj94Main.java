package com.huawei.practise;

import java.sql.SQLSyntaxErrorException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 计票统计
 * <p>
 * 题目描述
 * 请实现一个计票统计系统。你会收到很多投票，其中有合法的也有不合法的，请统计每个候选人得票的数量以及不合法的票数。
 * 本题有多组样例输入。
 * 输入描述:
 * 输入候选人的人数n，第二行输入n个候选人的名字（均为大写字母的字符串），第三行输入投票人的人数，第四行输入投票。
 * <p>
 * 输出描述:
 * 按照输入的顺序，每行输出候选人的名字和得票数量，最后一行输出不合法的票数。
 * <p>
 * 示例1
 * 输入
 * 复制
 * 4
 * A B C D
 * 8
 * A D E CF A GG A B
 * 输出
 * 复制
 * A : 3
 * B : 1
 * C : 0
 * D : 1
 * Invalid : 3
 */
public class Hj94Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Map<String, Integer> voteCountMap = new LinkedHashMap<>();
            int errorCount = 0;
            int count = scanner.nextInt();
            for (int i = 0; i < count; i++) {
                String next = scanner.next();
                voteCountMap.put(next, 0);
            }
            int voteCount = scanner.nextInt();
            for (int i = 0; i < voteCount; i++) {
                String next = scanner.next();
                if (voteCountMap.containsKey(next)) {
                    voteCountMap.put(next, voteCountMap.get(next) + 1);
                } else {
                    errorCount++;
                }
            }
            voteCountMap.forEach((k, v) -> {
                System.out.println(k + " : " + v);
            });
            System.out.println("Invalid : "+errorCount);
        }
    }

}
