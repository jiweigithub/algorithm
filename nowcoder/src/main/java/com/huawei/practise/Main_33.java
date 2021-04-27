package com.huawei.practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 整数与IP地址间的转换
 *
 * 题目描述
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 *
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 *
 * 本题含有多组输入用例，每组用例需要你将一个ip地址转换为整数、将一个整数转换为ip地址。
 *
 *
 *
 * 输入描述:
 * 输入
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 *
 * 输出描述:
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 *
 * 示例1
 * 输入
 * 复制
 * 10.0.3.193
 * 167969729
 * 输出
 * 复制
 * 167773121
 * 10.3.3.193
 */
public class Main_33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            if (input != null && input.length() > 0) {
                ip2Integer(input);
            }
            String input2 = sc.nextLine();
            if (input2 != null && input2.length() > 0) {
                integer2Ip(Long.parseLong(input2));
            }

        }
    }

    private static void ip2Integer(String input) {
        String[] split = input.split("\\.");
        StringBuilder builder = new StringBuilder();
        for (String ipPart : split) {
            String binaryString = toBinaryString(Long.parseLong(ipPart));
            builder.append(binaryString);
        }
        String toString = builder.toString();
        long aLong = Long.parseLong(toString, 2);
        System.out.println(aLong);
    }

    private static void integer2Ip(Long lon) {
        String binaryString = Long.toBinaryString(lon);
        List<String> ipPartList = new ArrayList<>();
        while (binaryString.length() > 8) {
            int index = binaryString.length() - 8;
            ipPartList.add(binaryString.substring(index));
            binaryString = binaryString.substring(0, index);
        }
        ipPartList.add(binaryString);
        Collections.reverse(ipPartList);
        for (int i = 0; i < ipPartList.size(); i++) {
            String ipPart = ipPartList.get(i);
            long parseLong = Long.parseLong(ipPart, 2);
            ipPartList.set(i, String.valueOf(parseLong));
        }
        String result = String.join(".", ipPartList);
        System.out.println(result);
    }

    private static String toBinaryString(long num) {
        StringBuilder result = new StringBuilder();
        int flag = 1 << 7;
        for (int i = 0; i < 8; i++) {
            int val = (flag & num) == 0 ? 0 : 1;
            result.append(val);
            num <<= 1;
        }
        return result.toString();
    }
}
