package com.huawei.practise;

import java.util.*;
import java.lang.*;

public class Hj89Main{
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