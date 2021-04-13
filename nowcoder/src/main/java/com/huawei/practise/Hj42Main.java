package com.huawei.practise;

import java.util.*;

/**
 * 学英语
 * <p>
 * 题目描述
 * Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
 * <p>
 * 如22：twenty two，123：one hundred and twenty three。
 * <p>
 * <p>
 * 说明：
 * <p>
 * 数字为正整数，长度不超过九位，不考虑小数，转化结果为英文小写；
 * <p>
 * 输出格式为twenty two；
 * <p>
 * 非法数据请返回“error”；
 * <p>
 * 关键字提示：and，billion，million，thousand，hundred。
 * <p>
 * <p>
 * 本题含有多组输入数据。
 * <p>
 * 输入描述:
 * 输入一个long型整数
 * <p>
 * 输出描述:
 * 输出相应的英文写法
 * <p>
 * 示例1
 * 输入
 * 2356
 * 输出
 * two thousand three hundred and fifty six
 * <p>
 * 10=ten
 * and
 * 100=hundred
 * 1000=thousand
 * and
 * 1000000=million
 * and
 * 10000000=billion
 * 10000000000=giga
 */
public class Hj42Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            printEnglish(input);
        }
    }

    public static void printEnglish(String input) {
        Map<Long, String> dict = new HashMap<>();
        dict.put(0L, "zero");
        dict.put(1L, "one");
        dict.put(2L, "tow");
        dict.put(3L, "three");
        dict.put(4L, "four");
        dict.put(5L, "five");
        dict.put(6L, "six");
        dict.put(7L, "seven");
        dict.put(8L, "eight");
        dict.put(9L, "nine");
        dict.put(10L, "ten");
        dict.put(11L, "eleven");
        dict.put(12L, "twelve");
        dict.put(13L, "thirteen");
        dict.put(14L, "fourteen");
        dict.put(15L, "fifteen");
        dict.put(16L, "sixteen");
        dict.put(17L, "seventeen");
        dict.put(18L, "eighteen");
        dict.put(19L, "nineteen");
        dict.put(20L, "twenty");
        dict.put(30L, "thirty");
        dict.put(40L, "forty");
        dict.put(50L, "fifty");
        dict.put(60L, "sixty");
        dict.put(70L, "seventy");
        dict.put(80L, "eighty");
        dict.put(90L, "ninety");
        dict.put(100L, "hundred");
        dict.put(1000L, "thousand");
        dict.put(100000L, "million");
        dict.put(10000000L, "billion");
        List<String> stack = new ArrayList<>();
        if (input.length() > 9) {
            System.out.println("error");
        }
        try {
            long value = Long.parseLong(input);
            buildEnglish(dict, stack, value);
        } catch (Exception e) {
            System.out.println("error");
        }
        String join = String.join(" ", stack);
        System.out.println(join);
    }

    private static void buildEnglish(Map<Long, String> dict, List<String> stack, long value) {
        long v1 = 0;
        long v2 = 0;
        if (value >= 1000000 && value < 100000000) {
            v1 = value / 1000000;
            v2 = value % 1000000;
            buildEnglish(dict,stack,v1);
            stack.add("million");
        }

        if (value >= 1000 && value < 1000000) {
            v1 = value / 1000;
            v2 = value % 1000;
            buildEnglish(dict,stack,v1);
            stack.add("thousand");
        }

        //当值大于等于100，小于等于1000时
        if (value >= 100 && value < 1000) {
            v1 = value / 100;
            v2 = value % 100;
            stack.add(dict.get(v1));
            stack.add("hundred");
            if (v2 != 0) {
                stack.add("and");
            }
        }
        //当值大于等于20小于100时
        if (value >= 20 && value < 100) {
            v1 = value % 10;
            v2 = value - value % 10;
            if (v1 > 0) {
                stack.add(dict.get(v2) + " " + dict.get(v1));
            } else {
                stack.add(dict.get(v2));
            }
            v2 = -1;
        }
        //当值小于20时
        if (value < 20) {
            stack.add(dict.get(value));
            v2 = 0;
        }
        if (v2 > 0) {
            buildEnglish(dict, stack, v2);
        }
    }

}
