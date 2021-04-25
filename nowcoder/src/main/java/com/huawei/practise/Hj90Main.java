package com.huawei.practise;

import java.util.Scanner;

/**
 * 合法IP
 */
public class Hj90Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            String[] arr = s.split("\\.");
            if (helper(arr)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean helper(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (invalid(arr[i])) return false;
        }
        return true;
    }

    private static boolean invalid(String s) {
        if (s == "") return true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return true;
            }
        }
        if (Integer.valueOf(s) > 255) return true;
        return false;
    }
}
